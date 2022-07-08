void call(){
    stage("SAM: Build"){
     node{
        println "hey from the build step"
        sh 'python3 -m venv venv && venv/bin/pip install aws-sam-cli'
        stash includes: '**/venv/**/*', name: 'venv'
     }
    }
     stage('Build-sam') {
      node {
        unstash 'venv'
        sh 'venv/bin/sam build'
        stash includes: '**/.aws-sam/**/*', name: 'aws-sam'
      }
    }
}
