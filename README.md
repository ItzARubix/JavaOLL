# JavaOLL
An interpreter for [Our Little Language](https://github.com/basvdl97/OLL-Interpreter), written in Java

## Usage Instructions
1. [Clone the repository](https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository)
2. On your machine, navigate to the cloned repository
3. Run `./OLL /path/to/program` where `/path/to/program` is replaced with the file path of your program written in OLL

## Upkeep and Installation via Package Managers
It is unlikely that I will be updating the interpreter from its current state, as though there are still some potential improvements that could be made, I am mostly satisfied with what I have and do not wish to continue maintaining this package as of right now. 

I will still read and accept pull requests (so feel free to make your own contributions if you wish). I also am not _necessarily_ going to abandon this project permanently, and I may come back to this in the future. 

I have no intentions of setting up and uploading this project as a package to the AUR or any other repository for the sake of a package manager. This project is very narrow in scope and is unlikely to be used by many people, and the few who do care to use it can clone the repository on their own; this software does not have any effects outside of the cloned folder, as running the Bash script or otherwise invoking the interpreter does not create any files or have any other effects, it simply logs things to the standard output. There is thus no need to build this application as a package given its simplistic nature. 

If, for whatever reason, this project gets attention to the point where more than a few people would intend to use it, then I may make a `PKGBUILD` and publish this project to the AUR, if only for the convenience of its users. 
