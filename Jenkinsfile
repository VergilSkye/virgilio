#!/usr/bin/env groovy

node {
    stage('checkout') {
        checkout scm
    }

    gitlabCommitStatus('build') {
        stage('check java') {
            sh "java -version"
        }

        stage('clean') {
            sh "chmod +x mvnw"
            sh "./mvnw -ntp clean -P-webapp"
        }
        stage('nohttp') {
            sh "./mvnw -ntp checkstyle:check"
        }

        stage('install tools') {
            sh "./mvnw -ntp com.github.eirslett:frontend-maven-plugin:install-node-and-npm -DnodeVersion=v14.16.1 -DnpmVersion=7.11.2"
        }

        stage('npm install') {
            sh "./mvnw -ntp com.github.eirslett:frontend-maven-plugin:npm"
        }
        stage('backend tests') {
            try {
                sh "./mvnw -ntp verify -P-webapp"
            } catch(err) {
                throw err
            } finally {
                junit '**/target/surefire-reports/TEST-*.xml,**/target/failsafe-reports/TEST-*.xml'
            }
        }

        stage('frontend tests') {
            try {
                sh "./mvnw -ntp com.github.eirslett:frontend-maven-plugin:npm -Dfrontend.npm.arguments='run test'"
            } catch(err) {
                throw err
            } finally {
                junit '**/target/test-results/TESTS-results-jest.xml'
            }
        }

        stage('packaging') {
            sh "./mvnw -ntp verify -P-webapp -Pprod -DskipTests"
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
        }

        stage('deploy'){
            if(scm.branches[0].name ==~ /(\*\/develop)/){
                echo 'Branch developer'
                sh "cp ./target/*.jar /opt/jh/virgilio-dev/app.jar"
                sh "sudo systemctl restart virgilio-dev"
            } else {
                echo 'Branch master'
                sh "cp ./target/*.jar /opt/jh/virgilio-prod/app.jar"
                sh "sudo systemctl restart virgilio-prod"
            }
        }
    }
}
