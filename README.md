[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/9KRgXy8n)
# CS230X-assignment3-F24
# Choosing the top school


## Goals:
- [ ] Manipulating arrays of objects. (No use of Java's Arrays class is permitted.)
- [ ] Using looping constructs appropriately for processing array elements.
- [ ] Getting a better understanding of testing and debugging arrays.
- [ ] Practicing inheritance relationships.

## Exercise: Choosing the top school

There are many online resources that provide valuable information about undergraduate programs, and how to choose programs that best fit an individual student's interests and needs. One interesting website allows you to customize the ranking of undergraduate programs based on your own weighing of various criteria that attempt to capture the quality of these programs. In this problem you will implement a small version of a program that computes the top-ranking undergraduate school based on some factors (academics, facilities, social life, and your own impression/feeling about the school).

1. **Create School.java:**

Define a class, `School`, to store information about a single undergraduate school. For our purposes here, a `School` instance is characterized by its name, a rating of its academic programs, a rating of its facilities (libraries, sports centers, dorms, etc.), and a rating of its social life.

Your task:

 1. Set up the appropriate `instance variables`, according to the description above.
 2. Provide the primary building blocks for this class: a `constructor` to create instances of `School` objects, means for `printing an instance` of type `School`, and any appropriate getters/setters.
 3. Add the `main()` method, and put testing code for each method in `main()` as you write the methods. 
 4. Write your javadoc as you are defining the methods.
 5. Provide a method that allows you to check two `School` objects for equality. Two schools are considered equal if they have the same name.

The ratings for the factors we use here, i.e. (academics, facilities, social life, and your own impression/feeling), are be in the range [1 .. 10]. Your program should make sure that no values outside this range are accepted.


2. **Create VisitedSchool.java:**

Before one decides on their top school, it is useful to visit the schools under their consideration. It turns out that schools offer virtual tours these days for the prospective students who cannot visit in person.
Such visits are important, since prospective students are often able to form a certain vibe for schools during their visits.

Create a new class for `VisitedSchool`. A `VisitedSchool` is everything a `School` is, as well as having a preference rating, and an overall rating. This overall rating is computed as a weighted sum of a `School`'s ratings for academics, facilities, and social life, as well as the rating obtained after visiting (preference rating). 

Now, include this personal vibe as a factor in your rating system. We'll call it a `preference rating`.

Now that all ratings (academics, facilities, social life, and your own preference) for a visited school are available, an overall score for it can be computed. Of course different students give different weight to the factors used for computing the score of a school. For example, one might care strongly about social life, but less so about facilities. We want our ranking system to offer this capability!

Your task:
1. Think carefully about setting this class up. What is the relationship between `School` and `VisitedSchool`?
2. Set up any necessary instance variables.
3. Provide the primary building blocks for this class: constructor(s), getters/setters, String representations. Remember that it's good practice to document and test each method thoroughly before moving on to the next one.
4. Provide a method, `computeOverallRating()`, that computes the overall rating of a `VisitedSchool`. Recall that different users may value each ranking factor (academics, facilities, social life, and preference after visiting) differently, so this method should take as arguments the weight for each one of the 4 factors we are considering. This method then computes the overall rating as the weighted sum, Σ(weight * factor), of the evaluation factors, and sets the overall rating accordingly. Ensure that weights are in the integer range [0 .. 5].
5. Add a `main()` method to this class to show that you have tested its functionality. 

2. **Create SchoolRankingSystem.java:**

Define a new class, `SchoolRankingSystem`, that stores information about a collection of `VisitedSchool` objects. Use an array as the container for the `VisitedSchool` objects. Once the user enters their weights for academics, facilities, social life, and preference (after visit), the program computes the overall rating for all schools in the collection, as the weighted sum of all the rating factors. (See the Sample run provided at the end of this document.)

Your task:

Once more, add a `main()` method to the class and use it to test each method as soon as soon as the method is defined!

1. Set up the appropriate instance variables in the `SchoolRankingSystem` class.

2. Provide the primary building blocks for a class: a constructor for the `SchoolRankingSystem` class, necessary getters/setters, means for printing an instance of type `SchoolRankingSystem`. (Hint: This method should implicitly use the printing method in the `School` class!)

3. Clients should be able to add new schools to the collection. Given a school, a client can visit it (and, hence, form a personal opinion), and then they can add this VisitedSchool to their collection. Formally, define a method, `addSchool(School s, int ratePref)`, that takes as input a School object and a preference rating (after visiting) and adds a VisitedSchool object to the collection. If the school already exists in the collection, this won't add it again, but it will update the `ratePref` for that school.
NOTE: How are you going to check whether a school is already in the collection?

4.  Define a method, `computeAllRatings()` that computes and sets the overall rating for all visited schools in the collection. Hint: You have some design choices to make here, depending on your implementation. 

5.  Provide a method `findTopSchool()` to find the top school in the collection, based on its overall rating. (If there is a tie, choose any of them.) The method doesn't take an input, and will return the `VisitedSchool` with the highest rating.


Sample run of `main()` in `SchoolRankingSystem`:
```
There are 4 schools in the database:
Williams Academic rating: 10 Social rating: 5 Facilities rating: 3 *Preference rating*: 7
***Overall Rating***: 68
Wellesley Academic rating: 10 Social rating: 10 Facilities rating: 10 *Preference rating*: 7
***Overall Rating***: 108
Brown Academic rating: 10 Social rating: 5 Facilities rating: 1 *Preference rating*: 6
***Overall Rating***: 54
Smith Academic rating: 4 Social rating: 10 Facilities rating: 3 *Preference rating*: 8
***Overall Rating***: 65

#### Printing top schools overall ####
#### Weights for Academics, Facilities, Social and Preferences are: 2, 4, 5, 1 ####
Wellesley Academic rating: 10 Social rating: 10 Facilities rating: 10 *Preference rating*: 7
***Overall Rating***: 108
```

NOTE.
It is expected that your code has careful and meaningful **documentation** (top of the file and top of methods javadoc, as well as inline documentation) for each class. Top of the file javadoc should include a description of the class, values for the `@author` and `@version` tags. Top of the method javadoc should include values for the `@param` and `@return` tags as needed.

## SAVING YOUR WORK ON GITHUB
As we have discussed in class, it is important to work on labs and assignments regularly and save frequently. You should test your work incrementally, which will require you to save your file before compiling/running it. In addition to saving your work on your local machine, you should also frequently push your work to this Github repository. You can refer to Lab0 and the [Git and Github tutorial](https://github.com/CS230X-F24/github-starter-course) for a refresher on using these tools. 

## SUBMITTING TO GRADESCOPE
Turn in your work submitting files School.java, VisitedSchool.java, and SchoolRankingSystem.java to your Gradescope account for Assignment 3. [Click here for Gradescope instructions.](https://docs.google.com/document/d/1zGAJrbdAhfPZVlyDP9N3MmdKXWvNo7rQqehKNM5Q0_M/edit) 

## AUTOGRADER
When you submit your assignment to Gradecope, you will not immediately see feedback. You are welcome to resubmit as many times as you wish until the deadline but you will only receive feedback after the grades have been published. Click here for 230X instructions on: [testing your code](https://docs.google.com/document/d/19cKOyolT8UtSfMNrVw8MGgVWS-lYgHpBs8g2Cf_8Vvc/edit#heading=h.rt39ohf1jp6s), [styling your code](https://docs.google.com/document/d/14uwj9HAjNKfFBm0ZjUpWR7jdqKSj13rudIEJaG74mPk/edit), and [documenting your code](https://docs.google.com/document/d/15uqs_NH8y2sAuLLpiZuSxlI0UsL6a8CHuWY_qcvF4B4/edit). 

## ASSIGNMENT SOLUTIONS
Assignment solutions will not be shared. If you did not get full credit on the assignment, you should review the feedback and ask me or the TAs if you have further questions.   
