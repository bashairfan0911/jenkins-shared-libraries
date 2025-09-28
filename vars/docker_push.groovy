def call(String projectName, String imageTag, String dockerHubUser, String credentialsId = "DockerHubCred") {
    echo "Pushing Docker image: ${dockerHubUser}/${projectName}:${imageTag}"

    withCredentials([usernamePassword(credentialsId: credentialsId, passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
        sh """
            echo \$dockerHubPass | docker login -u \$dockerHubUser --password-stdin
            docker push ${dockerHubUser}/${projectName}:${imageTag}
        """
    }
}
