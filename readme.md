# countOccurrences App

countOccurrences App is a simple app that counts the occurences of a word in a text document. 

## Installation

Use git to clone the repository https://github.com/BartekJimenez/countOccurrences.git

```bash
git clone https://github.com/BartekJimenez/countOccurrences.git
```

Make sure you are using Java 8 and the latest JDK. Review the path for the files in the file Runner.java(will be changed in the future).

## Usage


Check the project out to Eclipse and run the project as a Java application.

You will be now greeted by a terminal entry:

```bash
Is this a system test?
```

You can only respond yes or no in lowercase.

If you'd like to search the documents for a specific word, hit no. You'll then be greeted by:
```bash
Is this a system test?
no
Please enter a search term:
```

Enter any word you want, I recommend "the". Then choose which search method you'd like to use by entering a number between 1-3:
```bash
Is this a system test?
no
Please enter a search term:
the
Please choose a search method:
1) String Match
2) Regular Expression
3) Indexed
```

you will now get your results:
```bash
Is this a system test?
no
Please enter a search term:
the
Please choose a search method:
1) String Match
2) Regular Expression
3) Indexed
1
The word the appears 64 times using String Search in french_armed_forces.txt.
The word the appears 29 times using String Search in hitchhikers.txt.
The word the appears 6 times using String Search in warp_drive.txt.
Execution time in milliseconds : 38
```

You can mimic the same procedure with different search terms and choices 1-3. Alternatively if you'd like to test the system you can just restart the program and choose "yes" at start. You will then get to choose between 1-3 and once a choice is made, the system will stress 2m random entries in the search algorithom of your choosing.


## Results

2m records with random search terms:
572957ms for String Match.
249294ms for Regular Expression.
156793ms for IndexOf.


Do note that when you stress the system, all the documents get loaded into memory where all the unique words are used as list that the random selector chooses from, hence all the words have relevance. 


## TODOS

Currently the app is a work in progress, with the focus making sure the core functions work. You may notice that it can be error prone if a user enters an incorrect value, requiring a restart. The next additions will focus on ensuring that the program doesn't result in any errors from user input!

