def install(pipPath) {
    bat """
        echo Current directory: %CD%
        git clone https://github.com/mtararujs/python-greetings .
        dir
        "${pipPath}" install -r requirements.txt
    """
}
return this
