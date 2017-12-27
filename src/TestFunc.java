





public class TestFunc implements GradeFunction{
	

    private int numClasses;
    private int maxGrade;

    public TestFunc(int n, int g){
	this.numClasses = n;
	this.maxGrade = g;
    }

    /*
     * This grade function is dumb: for every hour you spend on any course
     * you get one grade "point"
     */
   public int grade(int classID, int hours){
	  
	   
	  int x = classID;
	   
	   
	return (int)  Math.min(Math.log(x+1), maxGrade);
	
	
    }
    
    
    

	

}
