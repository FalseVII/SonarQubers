

pipeline {
	agent any
	
	stages {
		stage('Build'){
			steps {
				sh "mvn clean compile"
			}
		}

		stage('Unit Tests'){
			steps {		 	 	
				sh "mvn test"
								
					
			}
		}

		



		stage('Package') {
			steps {
				sh "mvn package"		
			}
		}
		
	}

}

