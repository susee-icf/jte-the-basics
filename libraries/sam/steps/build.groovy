void call(){
    stage("SAM: Build"){
        println "hey from the build step"
        sh 'python3 -m venv venv && venv/bin/pip install aws-sam-cli'
        stash includes: '**/venv/**/*', name: 'venv'
    }
}
