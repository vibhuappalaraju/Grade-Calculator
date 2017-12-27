/* 
Vibhu Appalaraju
EID:vka249

*/
public class Program3 implements IProgram3{
	

    private int numClasses;
    private int maxGrade;
    private GradeFunction gf;
    int[][] matrix; // this matrix contains all optimal grades with given hours and classes
    int[][] hoursmatrix; // this matrix contains all the values of k with the optimal grade
    
    int [] computeGrades;
    int [] computeHours;


    public Program3() {
        this.numClasses = 0;
        this.maxGrade = 0;
        this.gf = null;
    }
    /**
     * 
     */
    public void initialize(int numClasses, int maxGrade, GradeFunction gf){
        this.numClasses=numClasses;
        this.maxGrade=maxGrade;
        this.gf=gf;
    }
    /**
     * This first uses the function makematrix to make a matrix with optimal grades
     * then computes the array of hours using the hours matrix which has the best k for the optimal grade
     */
    public int[] computeHours(int totalHours){
    	
    		makematrix(numClasses,totalHours);
    		
    		int[] Arrayofgrades= new int[numClasses];
    		int[] Arrayofhours = new int[numClasses];
    		int hour=totalHours;
    		
    		for(int i = numClasses-1; i >= 0; i--)
    		{
        		Arrayofhours[i] = hoursmatrix[i][hour];
                Arrayofgrades[i] = gf.grade(i, hoursmatrix[i][hour]);
                hour -= hoursmatrix[i][hour];
    			}	
    		computeHours=Arrayofhours;
    		computeGrades = Arrayofgrades; 
    		
    	return computeHours;
    }

    /**
     * This first uses the function makematrix to make a matrix with optimal grades
     * then computes the array of grades using the hours matrix which has the best k for the optimal grade
     * and uses the grade function as well. 
     */
    public int[] computeGrades(int totalHours){
       
    		makematrix(numClasses,totalHours);
    		int[] Arrayofgrades= new int[numClasses];
    		int[] Arrayofhours = new int[numClasses];
    		int hour=totalHours;
    		
    		for(int i = numClasses-1; i >= 0; i--)
    		{
        		Arrayofhours[i] = hoursmatrix[i][hour];
                Arrayofgrades[i] = gf.grade(i, hoursmatrix[i][hour]);
                hour -= hoursmatrix[i][hour];
    			}	
    		computeHours=Arrayofhours;
    		computeGrades = Arrayofgrades; 
    		
    		
    		
    	return computeGrades;
    	}

    	
    
    /**
     *  This matrix computes a matrix with the optimal grades given the current hours and classes. 
     *  it is computed dynamically. This BigO is Nh^2.
     *  */
    
    
    public void makematrix( int ncourses, int Hhours){
    	 matrix = new int [ncourses][Hhours+1];
         hoursmatrix = new int [ncourses][Hhours+1];
    	
    	 for(int n=0;n<ncourses;n++){
    		 for(int h=0;h<Hhours+1;h++){
    			 int max_in_matrix =-1;
    			 int grade_with_k = -1;
    			 int present_k=0;
    			 for(int k=0;k<=h;k++){
    				 int newmax;
    				 int present_grade= gf.grade(n,k);
    				 if(n==0){newmax=present_grade;}
    				 else{newmax=present_grade + matrix[n-1][h-k]; }
    				 if(newmax>max_in_matrix)
    				   { max_in_matrix=newmax;
    				     present_k=k;
    				     grade_with_k=present_grade;} 
    				 
    				 
    				 //closes k for loop
    			 }
	    			 matrix[n][h] = max_in_matrix;
                     hoursmatrix[n][h] = present_k;
    			 
    		//closes for loop h	 
    		 }	 
    	//closes forloop of n	 
    	 }
    //closesfunction	
    }
    
	
}
