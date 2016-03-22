# Andoid-AkshatPieEstimatorModified
       		  =======================================================
         		      Android Application Development
                  		        CIS 4930
		  =======================================================



		           Application Name-Akshat Pie Estimator
  	             -----------------------------------------------


		        	 Project Description
               
 		In this android app we hav to create a monte carlo simulation to
	        estimate the value of pie.User enters how many cycles they want 
		and after every 1000 the latest estimate.The important files and 
                their description is as under:


                 MainActivity.java

                This .java file is the main file in which the object of the 
                Thread is created and the thread created by me is accessed.
		It has the follwing functions:

		    public void onCreate(View view)
					
			This functions takes the input from the user and stores
		the value in instance varable C. When the user clicks on the 
		generate button, the listener handler is executed and thread 
		object is created. This function also displays the output of
		the application.		

        	    public void onClear()

			  This function is called when the user clicks on the
		clear button which clears all the text fields and edit text
		fields.

                         //////////////////////////////
		 
		 MyAppThread.java

		 This .java file is a programmer defined thread class which 
		 performs all the functions of estimation of value of pie.
		

        	    public void run()

			  This function is called when the user clicks on the
		generate button and the thread object is created and the start()
		function is called which calls the run() function. 

		    public static boolean [] putPoints(int r, int d)	

			   This function is used to put points on the graph i.e.
		inside or outside the circle using random number generator
   		function.

		    public static double myEstimator(boolean [] h, int d)

			   This function performs the estimation of the values
		of pie for each cycle.      

       
                          /////////////////////////////

                 activity_main.xml

		This .xml file is used to design the user interface of the 
		apllication. The layout for the application is relative and 
		I have used  buttons and text views for the interface.


       ////////////////////////////////////////////////////////////////////////////////////
       ////////////////////////////////////////////////////////////////////////////////////
