public class TestScores {

    // these are the score values for our tests
    private double score1, score2, score3;

    // alright, so these are the starting scores set as doubles
    public TestScores(double s1, double s2, double s3) {
        score1 = s1;
        score2 = s2;
        score3 = s3;
    }

    // setting the score for test 1
    public void setScore1(double n) {
        score1 = n;
    }

    // setting the score for test 2
    public void setScore2(double n) {
        score2 = n;
    }

    // setting the score for test 3
    public void setScore3(double n) {
        score3 = n;
    }

    // getting the score for the first test
    public double getScore1() {
        return score1;
    }

    // getting the score for the second test
    public double getScore2() {
        return score2;
    }

    // the score for the third test
    public double getScore3() {
        return score3;
    }

    // making a getter for the average score to calculate it
    public double getAverageScore() {
        return (score1 + score2 + score3) / 3; // basic math to get the arithmetic mean
    }
}
