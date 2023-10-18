# Foundation Exam Extra Practice

<!-- toc -->

- [1. Write Words into Matrix](#1-write-words-into-matrix)
- [2. Filter Words from Matrix](#2-filter-words-from-matrix)
- [3. Transpose the Matrix](#3-transpose-the-matrix)
- [4. Scrabble Word Scores](#4-scrabble-word-scores)
- [5. Test Result Grading](#5-test-result-grading)
- [6. Store Accounting](#6-store-accounting)

<!-- tocstop -->

## 1. Write Words into Matrix

Write a function that takes a string as its first argument, and two integers as
its 2nd and 3rd arguments that define the size of a matrix. It should create a
matrix with the given dimensions and write the words of the string into the
matrix. It should throw an exception if the words overflow or cannot completely
fill the matrix.

### Example 1

```java
createWordMatrix("miles to go before I sleep", 2, 3)
```

should return:

```text
[
  [miles, to, go],
  [before, I, sleep]
]
```

### Example 2

```java
createWordMatrix("miles to go before I sleep", 3, 2)
```

should return:

```text
[
  [miles, to],
  [go, before],
  [I, sleep]
]
```

### Example 3

```java
createWordMatrix("to go before I sleep", 2, 3)
```

should throw an exception because the words of the input don't fill the matrix
(5 words for 6 places).

### Example 4

```java
createWordMatrix("and miles to go before I sleep", 2, 3)
```

should throw an exception because the words of the input overflow the matrix (7
words for 6 places).

## 2. Filter Words from Matrix

Write a function that takes a matrix of strings as its first argument and a
string as its second argument. It should return a list of the words in the
matrix, but the words of the entire column that contains the given word should
be excluded.

### Example

```java
String[][] matrix = {
  { "alfa", "bravo", "charlie" },
  { "delta", "echo", "foxtrot" }
};
filterColumn(matrix, "echo");
```

should return:

```text
[alfa, charlie, delta, foxtrot]
```

because the 2nd column contains the word _echo_ and therefore _bravo_ and
_echo_ are excluded.

## 3. Transpose the Matrix

Write a function that takes a matrix of integers as argument and outputs the
transposed matrix: a new matrix in which the columns and rows of the original
are swapped (i.e. the first row becomes the first column etc.)

### Example

```java
int[][] matrix = {
  { 1, 2, 3 },
  { 4, 5, 6 }
};
transpose(matrix);
```

should return:

```text
[
  [1, 4],
  [2, 5],
  [3, 6]
]
```

## 4. Scrabble Word Scores

In this word game points are awarded based on the length of the word and the
letters used. The user has to create a word from the letters in their hand.
Their hand consists of 7 letters.

Create a function which returns the correct scores for the words played. The
input is an array of words, and the output is a hash-map where the keys are the
words played and the values are the word points.

The score of the word is the sum of the points of all the letters multiplied by
the number of letters in the word. If they use all 7 of their letters then they
get a 50-point bonus.

The letter points are:

```java
Map<Character, Integer> letterPoints = new HashMap<>();
letterPoints.put('a', 1);
letterPoints.put('b', 3);
letterPoints.put('c', 3);
letterPoints.put('d', 2);
letterPoints.put('e', 1);
letterPoints.put('f', 4);
letterPoints.put('g', 2);
letterPoints.put('h', 4);
letterPoints.put('i', 1);
letterPoints.put('j', 8);
letterPoints.put('k', 5);
letterPoints.put('l', 1);
letterPoints.put('m', 3);
letterPoints.put('n', 1);
letterPoints.put('o', 1);
letterPoints.put('p', 3);
letterPoints.put('q', 10);
letterPoints.put('r', 1);
letterPoints.put('s', 1);
letterPoints.put('t', 1);
letterPoints.put('u', 1);
letterPoints.put('v', 4);
letterPoints.put('w', 4);
letterPoints.put('x', 8);
letterPoints.put('y', 4);
letterPoints.put('z', 10);
```

Scoring examples:

- The word _great_ gives a score of 30. The sum of the letter values is 6 (g=2,
  r=1, e=1, a=1, t=1) and it is a 5-letter word, and 6*5=30.
- The word _jukebox_ gives a score of 239. The sum of the letter values is 27
  (j=8, u=1, k=5, e=1, b=3, o=1, x=8) and it is a 7-letter word therefore it
  gets the 50-point bonus, and 27*7+50=239.

### Example

```java
String[] words = { "great", "jukebox" };
calculateScore(words);
```

should return:

```text
{
  great=30,
  jukebox=244
}
```


## 5. Test Result Grading

We are writing a program for teachers that helps them grade test results. The
program receives the test results in a CSV file; each line of the file contains
the name of a student and their test score, divided by a comma (see below).

1. Write a function that takes the filename as argument and returns the
   percentages of passes and failures (e.g. 60% passed and 40% failed) as a
   hash-map in the following format:

   ```text
    {
      passed=60.0,
      failed=40.0
    }
    ```

2. Write a function that takes the filename as argument, grades the results A-F
   and returns a hash-map of the students' names with their grades. Use the
   following grading scale:
    - 0-39: F
    - 40-54: D
    - 55-69: C
    - 70-84: B
    - 85-100: A

### Example

results.csv:

```csv
Gytha Wheatley,35
Alishia Thorpe,83
Zack Vernon,59
Jaclyn Elliott,38
Ashlynn Albinson,66
Slade Marchand,24
Karen Warwick,90
Michael Foster,65
Dove Siddall,39
Frederick Pond,72
```

```java
getPercentages("results.csv");
```

should return:

```text
{
  passed=60.0,
  failed=40.0
}
```

and

```java
getGrades("results.csv");
```

should return:

```text
{
  Gytha Wheatley=F,
  Alishia Thorpe=B,
  Zack Vernon=C,
  Jaclyn Elliott=F,
  Ashlynn Albinson=C,
  Slade Marchand=F,
  Karen Warwick=A,
  Michael Foster=C,
  Dove Siddall=F,
  Frederick Pond=B
}
```

## 6. Store Accounting

We are writing a program module for an online shop that processes purchases.
The program receives the sold items in a CSV file; each line of the file
contains the name of an item, its price and its category; the 3 values are
separated by commas (see below).

Write a function that receives the name of the file as argument, and returns
the most profitable category (i.e. the category with the highest total price).

### Example

items.csv:

```csv
Premier Housewives Stainless Steel Toolset,19.97,homeware
iChinchin Women's Long Sleeve T Shirt,15.99,clothing
U-Design Toothbrush Holder Set,10.55,homeware
Elgar 400W Hand Mixer,25.99,appliances
Great Gatsby White and Gold Kettle,49.99,homeware
AM Bristol Men's Fitted Boxers,24.99,clothing
Disnoy Brittle Small Cookie Jar,10.01,homeware
Oreal-C Cross Action Electric Toothbrush,22.19,appliances
Wrundole Designs Duck Wall Clock,34.50,homeware
RuralComfort Dressing Gown for Men,26.99,clothing
```

```java
findMostProfitableCategory("items.csv");
```

should return:

```text
homeware
```

because the sum of homeware prices is 125.02, the sum of clothing prices is
69.97 and the sum of appliance prices is 48.18, i.e. the homeware is the
highest.
