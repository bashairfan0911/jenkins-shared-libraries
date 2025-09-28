def call(String projectName, String imageTag, String dockerHubUser) {
    withCredentials([usernamePassword(credentialsId: 'DockerHubCred', passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
        sh """
            echo \$dockerHubPass | docker login -u \$dockerHubUser --password-stdin
            docker push \$dockerHubUser/${projectName}:${imageTag}
        """
    }
}
