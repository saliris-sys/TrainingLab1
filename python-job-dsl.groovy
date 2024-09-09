job('Python-Build-Job') {
    description('A Jenkins job to build Python projects.')

    // Source Code Management
    scm {
        git('https://github.com/your-repo/python-project.git')
    }

    // Build Triggers
    triggers {
        scm('H/15 * * * *')  // Poll SCM every 15 minutes
    }

    // Build Steps
    steps {
        shell('pip install -r requirements.txt')  // Install dependencies
        shell('pytest')  // Run tests
    }

    // Post-build Actions
    publishers {
        archiveArtifacts('**/target/*.zip')
    }
