# Software you will need for this module

## Windows/Linux

- [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Visual Studio Code](https://code.visualstudio.com/)
- [Visual Studio Code Java Extensions](https://code.visualstudio.com/docs/languages/java)
- [Git](https://git-scm.com/download/)

Setting up Java on Windows:

[![YouTube](http://img.youtube.com/vi/WXftKFCtPrQ/0.jpg)](https://www.youtube.com/watch?v=WXftKFCtPrQ)


Install the above software. Create an empty folder on your computer. Right click on the folder and select Git Bash here.

To clone the repository for the course type:

```bash
git clone http://github.com/skooter500/OOP-2018-2019
```

Make a bin folder for your compiled Java classes. Compiled java files have a .class extension:

cd to the OOP-2018-2019/java folder and type:

```bash
mkdir bin
```

To compile and run the code, type:

```bash
./compile.sh
./run.sh
```

Open these two shell scripts in an editor to see what they contain.

You can also edit and run your code in Visual Studio Code! To do this open Visual Studio Code and choose File | Open Folder *not open file* and open the *java* folder in the repo. There are two files in this folder that tells VSC how to compile and the Java code. The most significant of these is the .classpath file. This is an XML file that lists all the jar files that the project depends on. Open the file in VSC and check it out.  jar files are zip files with a .jar extension that contain .class files. You should be able to open Main.java and choose Debug from the debug menu in VSC to compile and run the code.

## Lab Computers

Visual Studio code is not installed on the lab computers, so edit your Java code in Notepad++ and use the ```./compile.sh``` and ```./run.sh``` shell scripts to compile and run.

## Mac

Mac users will need JDK 8 *not JDK 11* as the Processing libraries we are using on the course are not compatible with Java 11 on the Mac. You can check to see if you already have the JDK installed by typing:

```bash
javac -version
```
Into the terminal window. If a different version (like JDK 11) is installed, you will need to remove it. To do this, type:

```bash
cd /Library/Java/JavaVirtualMachines
ls
```
This will list all the versions of Java you have installed. To remove version 11 (for example) type:

```bash
sudo rm -rf jdk-11.0.2.jdk
```

You can get Java 8, Visual Studio code etc for the Mac from here:

- [JDK 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Visual Studio Code](https://code.visualstudio.com/)
- [Visual Studio Code Java Extensions](https://code.visualstudio.com/docs/languages/java)

The first time you type ```git``` in the Mac terminal, the OS will prompt you to install the XCode command line tools that also contains git.

The path seperator on the mac is different to that on Windows, so to compile and run the code from the course, cd to the java folder in the repository and type:

```bash
./mcompile.sh
./mrun.sh
```

To use Visual Studio code, open the java folder in the repository. 

Visual Studio Code is almost working fine on the Mac, but for some reason even though I have removed JDK 11 from my mac, the project is still compiling with the JDK 11 compiler (if someone figures out why this is happening, please let me know!) How I get around this is to go to View | Terminal in Visual Studio Code. cd to the java folder (if you need to) and type ./mcompile.sh. Thereafter, you can go to the Debug menu to run your code.
