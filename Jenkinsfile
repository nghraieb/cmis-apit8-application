pipeline {
    agent any
    options {
        buildDiscarder(logRotator(daysToKeepStr: '10', numToKeepStr: '5', artifactNumToKeepStr: '1'))
        timeout(time: 60, unit: 'MINUTES')
        disableConcurrentBuilds()
    }
    environment {
        USER_CREDENTIALS= credentials('jenkins')
    }
    stages {
        stage('Clean') {
            steps {
                script {
                    GIT_COMMIT_VERS = sh (
                        script: 'git --no-pager show -s | sed -n \'1p\'',
                        returnStdout: true
                        ).trim()
                    GIT_COMMIT_MAIL = sh (
                        script: 'git --no-pager show -s | sed -n \'2p\'',
                        returnStdout: true
                        ).trim()
                    GIT_COMMIT_DATE = sh (
                        script: 'git --no-pager show -s | sed -n \'3p\'',
                        returnStdout: true
                        ).trim()
                    GIT_COMMIT_MES = sh (
                        script: 'git --no-pager show -s | sed -n \'5p\'',
                        returnStdout: true
                        ).trim()
                }
                sh "chmod +x mvnw"
                sh "./mvnw -ntp clean"
            }
        }
        stage('Unit Test') {
            steps {
                sh './mvnw -ntp test -Dcheckstyle.skip -Duser.timezone="+01:00"'
            }
        }
        stage('Check Code Style and Sonar Analysis') {
            parallel {
                stage('SonarQube Analysis') {
                    steps {
                        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                            echo 'SonarQube Analysis'
                            sh "./mvnw -ntp initialize sonar:sonar -Dsonar.host.url=http://localhost:9001 -Dcheckstyle.skip -DskipTests"
                        }
                    }
                    post {
                        always {
                            echo "quality code done"
                        }
                    }
                }
                stage('Check Code Style') {
                    steps {
                        sh "./mvnw -ntp checkstyle:check"
                    }
                }
            }
        }
        stage('Build and Push Docker') {
            when {
                branch 'main'
            }
            steps {
                sh "./mvnw -ntp jib:build -Pprod -DsendCredentialsOverHttp=true -Dcheckstyle.skip -DskipTests"
            }
        }
        stage ('Installation') {
            when {
                branch 'main'
            }
            steps{
                sh "docker service update --with-registry-auth --image 172.20.38.42:8184/contract:latest bscsms_contract"
            }
        }
    }
    post {
        always {
            mail bcc: '', body: "<b>Bonjour</b><br><br>Project: ${env.JOB_NAME} <br> Branch: ${env.BRANCH_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL} <br> Build Result : ${currentBuild.currentResult} <br><br> Commit Details: <br><br> ${GIT_COMMIT_VERS} <br> ${GIT_COMMIT_MAIL} <br> ${GIT_COMMIT_DATE} <br> Commit Message : ${GIT_COMMIT_MES}    <br><br> Cordialement <br> BSCSWS Refonte Team", cc: '', charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "CICD: Project name -> ${env.JOB_NAME}", to: "nidhal@ligado.com"; 
        }
    }
}
