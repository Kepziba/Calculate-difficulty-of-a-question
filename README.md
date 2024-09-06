# Calculate-difficulty-of-a-question
Algorithm to calculate the difficulty of a question

In this the algorithm is represented to calculate the difficulty of a question whether the assigned questions are easy, medium or hard.
Another important thing is that it provides accurate results and it is useful for online exam platforms.

The Factors to calculate the difficulty of a question is as follows:-
At first we Assign,
1) Assign the difficulty levels manually
2) Count of Students who are participated
3) Total amount of time taken to answer
4) Incase if it is a MCQ type question,then calculate the total count of time the option is changed
5) Incase if it is a Programming type question,then calculate the total number of times the program is changed
6) Calculate the total Number of hints that is to be used
7) For this question feedback is given by other students
8) Count of students who made it correct
9) Count of students who made it wrong
10)Count of students who made it partially correct
11)Total Marks Allocated for this question

>>>In this at first the Input is provided inform of a file that includes (-) seperated input string values of the factors that is specified above for each and every question.

>>>To Store the arraylist of values new hashmap is created that contain the process of time taken, number of changes or compilations and number of hints of each student.

>>>Using hashmap the total values of time taken, number of changes or compilations and number of hints are calculated.

>>>Obtain the average values for same.

>>>Thus the Process takes place.

>>>Then the factor is calculated to assign based on difficulty of Question as follows:

      Difficulty that is assigned manually is calculated based on the manually assigned difficulty either it is Easy, Medium or Hard,then the difficulty is provided.In an arrayList the difficulty is to be added.
      Based on the type of question as MCQ(includes fillup and match the following) or Programming and also taking manually assigned difficulty into consideration, few values are set and if the average time breaches these values, difficulty is set based on that.The difficulty is added to the arraylist.  
      Count of changes or compilations are based on the type of question as MCQ(includes fillup and match the following) or Programming and also taking manually assigned difficulty into consideration few values are set and if the average number of changes or compilations breaches the values, difficulty is set based on that.The it is added to the arraylist.
      Total number of hints are assigned and also based on the manually assigned difficulty,and a range  for indicating each type of difficulty.Then it is added to the arraylist.
      The number of hints is taken and the range of the difficulty is set based on some specific values taking manually assigned difficulty into consideration. The type difficulty is then added to the arraylist.
      Another difficulty is set based on the feedback given by other students to this particular question(easy/medium/hard). This difficulty is alse added to the arraylist.
      The overall marks of the question is calculated by multiplying total students who attended the question and the maximum marks provided as input. Marks of the student are calculated by multiplying the number of students who got it right with maximum marks and number of students who got it partially right with half of maximum marks. The difficulty is calculated by checking where the students marks lie in the division of the total marks by 3. The difficulty is added to the arraylist.
      The overall difficulty of the question is calculated by taking the arraylist frequency of each difficulty.

      The difficulty of the question is then printed.
