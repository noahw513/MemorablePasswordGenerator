# memorablePassword
A Java shell program that generates a memorable password in the form word-word-word. Word count in the password can specified. Optionally, a special character may be appended to the end of the password: word-word-word-[!, @, #, $, %, ^, &, *]. If no options are specified the program defaults to word-word-word.

USAGE:
java -jar memorablePasswordGenerator.jar -s -c 5
- Will return word-word-word-word-word-specChar
java -jar memorablePasswordGenerator.jar -c 2
- Will return word-word
java -jar memorablePasswordGenerator.jar 
- Will return word-word-word
java -jar memorablePasswordGenerator.jar
- Will return word-word-word-specChar


TODO:

(1) Create install packages:
- Debian
- Ubuntu
- RHEL
- CentOS
- Fedora
- Arch
- *BSD

(2) Abstract core logic into an object or class for easier reuse.
