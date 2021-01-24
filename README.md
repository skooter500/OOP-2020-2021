# DT228/DT282 Object Oriented Programming 2019-2020

Resources
---------
- [Install the software you will need for this module](install.md)
* [The Java Tutorial from Oracle](http://docs.oracle.com/javase/tutorial/)
* [Games Fleadh](http://www.gamesfleadh.ie/)
* [The Nature of Code](http://natureofcode.com/)
* [The git manual - read the first three chapters](http://git-scm.com/documentation)
* [A video tutorial all about git/github](https://www.youtube.com/watch?v=p_PGUltnB6w)
* [The Processing language reference](http://processing.org/reference/)

## Contact the lecturer
* Email: bryan.duggan@dit.ie
* Twitter: [@skooter500](http://twitter.com/skooter500)

# Assessments

- [Assignments](assignments.md)

- Week 11 Lab Test 20% 
- Week 12 Assignment Submission - 30%
- End of Year exam - 50%

# Week 1 - Introduction
## Lab
## Learning outcomes
- Fork the repo, configure the upstream remotes
- Write your first Java code
- Think about doing a project for Games Fleadh!

Firstly fork *this* repository by clicking the fork button above, so that you get your own copy of the repo to work on this semester. Now create a new empty folder on your computer somewhere or on your network drive and then right click on the folder and choose git bash here. Alternatively you can start the bash and cd to the new folder. To clone the repository for your fork:

```bash
git clone https://github.com/YOURGITUSERNAME/OOP-2019-2020
```

Replace YOURGITUSERNAME with your username. Now cd into the repo and check the origin and upstream remotes are set up correctly

```bash
cd OOP-2019-2020
git remote -v
```
You should see something like this:

```bash
origin  https://github.com/YOURGITUSERNAME/OOP-2019-2020 (fetch)
origin  https://github.com/YOURGITUSERNAME/OOP-2019-2020 (push)
upstream  https://github.com/skooter500/OOP-2019-2020 (fetch)
upstream  https://github.com/skooter500/OOP-2019-2020 (push)
```

If you don't see the upstream remote, you can set it up by typing

```bash
git remote add upstream https://github.com/skooter500/OOP-2019-2020
```
You can read more about forking a git repository and setting up the upstream remote in [this article](https://help.github.com/en/github/getting-started-with-github/fork-a-repo)

Once the upstream is setup, you will be able to push code to your own repo and also keep it up to date with the changes I make.

To compile and run the Java code in the src folder, you should type:

```bash
cd java
javac src/ie/tudublin/*.java -d bin
java -cp bin ie.tudublin.Main
```

You should see

```
Hello world!
Misty
Woof!
Meow!
```

On the terminal. If you do, then congratulations! You have successfully compiled and run your first Java program. Now create a branch to store your changes today. Best not to modify the master branch so you can keep it up to date with my changes:

```bash
git checkout -b lab1
```

Use an editor (like Visual Studio code or notepad++) to open up the files in the folder src/ie/tudublin and study them to see if you can figure out whats happening. Modify the code as follows:

- Write a method (functions are called methods in Java) on the Cat class called kill. It should subtract 1 from numLives if numLives is > 0 and print the message "Ouch!". If numLives is 0, you should just print the message "Dead"
- In the Main class in a loop, call kill until the Cat is dead.
- Compile and run your program until you have no bugs and you get the desired output.

Commit and push your changes:

```bash
git add .
git commit -m "killing the cat"
git push --set-upstream origin lab1
```

The "--set-upstream origin lab1" option is only required the first time you commit onto a new branch. After that you can just type "git push"

Check out [this article about last years Games Fleadh projects](https://www.dit.ie/computing/newsevents/eventscompetitions/eventsarticles/headline172312en.html). Have a look at the youtube videos and see what you think!

Check out the [Games Fleadh official website](http://gamesfleadh.ie)

[Download Unity Game Engine](https://unity.com/)

[Check out the Unity tutorials](https://learn.unity.com/) and start making some games!

Check out [this playlist](https://www.youtube.com/watch?v=jw5zXkg84A0&list=PL1n0B6z4e_E79Sl5I9Q7MlJk8tKjhHv_9) and [this playlist](https://www.youtube.com/watch?v=cW8s5i9dmqA&list=PL1n0B6z4e_E6jErrS0ScSCaVrN7KV729x) to get some inspiration if you plan to do the music visualiser assignment

## Lecture
- [Introduction slides](https://drive.google.com/file/d/1wdMcXJzaRBCSm4Ouj4_ZjWj9Mh292fQB/view?usp=sharing)
- [hello world](java/src/ie/tudublin)

Some assignments from previous years:

[![YouTube](http://img.youtube.com/vi/ENDHavHsL2k/0.jpg)](https://www.youtube.com/watch?v=ENDHavHsL2k)

[![YouTube](http://img.youtube.com/vi/zLXon_nlibY/0.jpg)](https://www.youtube.com/watch?v=zLXon_nlibY)

[![YouTube](http://img.youtube.com/vi/vecMCz1eB1s/0.jpg)](https://www.youtube.com/watch?v=vecMCz1eB1s)

[![YouTube](http://img.youtube.com/vi/xlEudfLH6Fg/0.jpg)](https://www.youtube.com/watch?v=xlEudfLH6Fg)

[![YouTube](http://img.youtube.com/vi/uykz5mCjV0w/0.jpg)](https://www.youtube.com/watch?v=uykz5mCjV0w)

[![YouTube](http://img.youtube.com/vi/sPjZSRCmt1U/0.jpg)](https://www.youtube.com/watch?v=sPjZSRCmt1U)