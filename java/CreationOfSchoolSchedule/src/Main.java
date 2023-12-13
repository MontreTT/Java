import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.Collections;
public class Main {
	//Koita vKAthigites sto add a lesson kai vgale to Vteachers Vector<String[][]>
	static int x =0 ;
	public static void main(String[] args ) throws  FileNotFoundException,IOException {
		//reads file and creates objects of Lessons, then puts then on a vector
		Vector<Object> vLessons = readfile(1,"C:\\Users\\Μανώλης\\Desktop\\MATHIMATA\\texnitino\\lessons.txt");
		//reads file and creates objects of Teachers then puts them on a vector
		Vector<Object> vKathigites = readfile(2,"C:\\Users\\Μανώλης\\Desktop\\MATHIMATA\\texnitino\\teachers.txt");
		
		//create the week list program arrays 
		
		Vector<String[][]> vProgramma=  new Vector<>(programmVector());
		Vector<String[][]> vTeachers=  new Vector<>(programmVector());
		Vector<String[][]> Stigmiotupo=  new Vector<>(programmVector());
		//κοινο αντικειμενο κλασης που περιεχει το προγραμμα και τους καθηγητες σαν λιστα ξεχωριστα το καθενα
		Vprogramma programm = new Vprogramma(vProgramma,vTeachers);
		//χαρτης που περιέχει ολα τα στιγμιοτυπα ,  σαν  βεκτορ που περιέχει κόμβους δέντρου οπου καθε κόμβος ενα στιγμιοτυπο του προγραμματος
		Vector<Stigmiotupo> clownFiesta = new Vector<Stigmiotupo>();
		//create a new Stigmiotupo 
		Stigmiotupo PriorStig =  new Stigmiotupo(0.0,vKathigites,vLessons,Stigmiotupo);
		double initStigCost =0;
		Vector<Double> temp1  = evaluation(PriorStig.getvKathigites());
		for(int p=0 ; p < temp1.size()  ;p++) {
			initStigCost += temp1.get(p);}
		PriorStig.setStigCost(initStigCost);
		/*for(int i =1 ; i <100;i++) {
			addALesson(PriorStig,0);
		} */                         
		//kappa gets true at the end
		boolean Kappa = false;
		int counter = 0;
		//while(!Kappa && counter <30){
			int size = 0;
			//vector which will have all Stigmiotupo objects 
			
			//we need to find how many teachers have still hours to teach
			Vector<Double> temp  = evaluation(PriorStig.getvKathigites());
			for(int p=0 ; p < temp.size()  ;p++) {
				initStigCost += temp.get(p);
				if(temp.get(p)>0) {
				size++;
				}
			}
			
			double disCost = 0;
			int q = 0;
			counter = 0;
			//do  {
			for(int i = 0 ; i < 15 ; i++) {
				Stigmiotupo tempS = new Stigmiotupo(PriorStig.getStigCost(),PriorStig.getvKathigites(),PriorStig.getvLessons(),PriorStig.getStigmiotupo());
				double disCost2 =0;
				disCost= 0;
				System.out.println(counter);
				if(PriorStig.getBurnedNums().contains(q)==false) {
				// creates an object with an array which contains the current schedule(at first its blank then contains only one subject etc)  and also their priority value
				Stigmiotupo a = new Stigmiotupo(PriorStig.getStigCost(),PriorStig.getvKathigites(),PriorStig.getvLessons(),PriorStig.getStigmiotupo());// φτιαχνω ενα καινουριο κομβο-στιγμιοτυπο , αντιγραφω το παλιο στιγμιοτυπο και οταν κανω αντ το επομενο μαθημα επειδη αλλαζει και ο κομβος πατερας κραταω τα στοιχεια του πατερα σε ενα τεμπ και μετα τα αλλαζω παλι
				addALesson(PriorStig,q);
				a.setvKathigites(PriorStig.getvKathigites());//κανει απντειντ το αρρει με τα ομπτζεκτ καθηγητων 
				a.setvLessons(PriorStig.getvLessons());       //κανει απντειντ το αρρε με τα ομπτζεκτ των μαθηματων 
				PriorStig.setStigmiotupo(tempS.getStigmiotupo());
				PriorStig.setvKathigites(tempS.getvKathigites());
				PriorStig.setvLessons(tempS.getvLessons());
				PriorStig.setStigCost(tempS.getStigCost());
				//Set the stigmiotupo priority to correct value
				Vector<Double> evaluation2 = evaluation(PriorStig.getvKathigites());
				Vector<Double> evaluation = evaluation(a.getvKathigites());
					for(int z= 0 ; z< evaluation.size(); z++) {
						disCost+= evaluation.get(z);
						disCost2+= evaluation2.get(z);
					}
					a.setStigCost(disCost);
					//add stigmiotupo to the vector
					clownFiesta.add(a);
		if(disCost == PriorStig.getStigCost()) {
				a.setBurned(true);
				PriorStig.getBurnedNums().add(q);
				if(PriorStig.getBurnedNums().size() == 19) {
					PriorStig.setBurned(true);
					}
				}
			System.out.println("DisCost " + disCost);
			System.out.println("DisCost2 " + disCost2);
			System.out.println(PriorStig.getStigCost());		
				}//}while(disCost != PriorStig.getStigCost());//μεχρι το κοστος του γιου να ειναι ισο με τον πατερα δλδ να μην υπαρχει προγκρες
			q++;
					// if no teacher has hours to teach break
			if(disCost == 0 ) {
				Kappa = true;
			}			
					
			int number=0;
			double maxPrioStigmio = 1000;
			//force a new PriorStig base on which Stigmiotupo has max  Priority
			for(int c=0 ; c< clownFiesta.size() ;c++) {
				if(clownFiesta.get(c).getStigCost()<=maxPrioStigmio ) {
					number= c;
					maxPrioStigmio = clownFiesta.get(c).getStigCost();
																	  }								  
													  }
			PriorStig = clownFiesta.get(number);
			counter++;
			
		
		
		
		
		}

		}
		
	//}
		
		
		
		
		
		
	//FileWriter writer = new FilesWriter("C:\\Users\\Μανώλης\\Desktop\\MATHIMATA\\texnitino\\kurwa.txt");
	//writer.write(fileContent);
	//writer.close();
	
	    


	
public static Vector<Object> readfile(int b,String a ){
	Vector<Object> Vvector = new Vector<Object>();
	
	try {
		String fileContent = "";
		File file = new File(a);
		Scanner scanner = new Scanner(file);
	
		while(scanner.hasNextLine()) {
			//reads raw files as string
			fileContent = fileContent.concat(scanner.nextLine() +" \n" );}
		
	
		//removes spaces and add elements to a vector
		String[] data = fileContent.split(" ");
		
		
		Vector<String> dataV = new Vector<>();
		for(int i = 0 ; i<data.length ; i++) {
			
			if (data[i].trim().length() > 0 == true){
				dataV.add(data[i]);
				}
		
		}
		
		if(b == 1) {
			//Vector<Lessons> Vvector = new Vector<Lessons>() ;
			for(int i = 4 ; i<dataV.size() && i+3 <dataV.size() ; i+=4 ) {
				//creates lessons objects and adds them to a Vlesson vector
				Lessons lesson = new Lessons(dataV.get(i),dataV.get(i+1),dataV.get(i+2),dataV.get(i+3));
				Vvector.add(lesson);}
		}
		else {
			//Vector<Teachers> Vvector = new Vector<Teachers>();
			for(int i = 4 ; i<dataV.size() && i+3 <dataV.size() ; i+=4 ) {
				Teachers teacher = new Teachers(dataV.get(i),dataV.get(i+1),dataV.get(i+2),dataV.get(i+3));
				Vvector.add(teacher);
		    }
		}
	}
	catch(FileNotFoundException e ) { 
		
		System.out.println("no file found");
		
	}
	return Vvector;
}
//returns a vector with hours per week divided by hours per day for each teacher


public static Vector<Double> evaluation(Vector<Object> VectorVt) {
	Vector<Double> evaluation_array = new Vector<>(VectorVt.size());
	for(int i = 0 ; i<VectorVt.size() ; i++) {
		String evaluation =((Teachers) VectorVt.get(i)).getMaxHours();
		String[] ev =evaluation.split("_");
		if(Integer.parseInt(ev[0])!= 0) {
			double b =  (double) ( Integer.parseInt(ev[1])) / Integer.parseInt(ev[0]);
			evaluation_array.add(b);
		
		}
		else {
			double b = 0;
			evaluation_array.add(b);
		}
		
	}
	return evaluation_array;
	
	
}
public static Vector<String[][]> programmVector(){
	String[][] A1 =  new String[8][5];
	A1[0][0] = "A1";
	String[][] A2 =  new String[8][5];
	A2[0][0] = "A2";
	String[][] A3 =  new String[8][5];
	A3[0][0] = "A3";
	String[][] B1 =  new String[8][5];
	B1[0][0] = "B1";
	String[][] B2 =  new String[8][5];
	B2[0][0] = "B2";
	String[][] B3 =  new String[8][5];
	B3[0][0] = "B3";
	String[][] C1 =  new String[8][5];
	C1[0][0] = "C1";
	String[][] C2 =  new String[8][5];
	C2[0][0] = "C2";
	String[][] C3 =  new String[8][5];
	C3[0][0] = "C3";
	Vector<String[][]> vProgramma=  new Vector<>();
	vProgramma.add(A1);
	vProgramma.add(A2);
	vProgramma.add(A3);
	vProgramma.add(B1);
	vProgramma.add(B2);
	vProgramma.add(B3);
	vProgramma.add(C1);
	vProgramma.add(C2);
	vProgramma.add(C3);
	return vProgramma;
	
}	
//adds a lesson to the array list
public static Vector<String[][]> addALesson(Stigmiotupo parent, int skippedPrio) {
	Teachers PriorT =  new Teachers("zero","zero","zero","zero");
	
	//Creates a vector of doubles with containts the current priorities rank of teachers
	Vector<Double> vPrioT = evaluation(parent.getvKathigites());
	
	//finds teacher with max current priority from the list
	//takes the teacher with max priority and makes him the priorTeacher
	//κανει ενα κοπυ αρρει με 
	Double[] tempP = new Double[parent.getvKathigites().size()];

	for(int i = 0 ; i <vPrioT.size(); i ++) {
			tempP[i]= vPrioT.get(i);
				
		
	}
	// παιρνει το χ ποιντερ του αρρει καθηγητων με το skippedPrion πραιοριτι
	Arrays.sort(tempP);

	
	for(int b=0 ; b < vPrioT.size(); b++){
		if( vPrioT.get(b) == tempP[tempP.length-1-skippedPrio] ) {
			PriorT = (Teachers) parent.getvKathigites().get(b);
			System.out.println(vPrioT.get(b));
			
		}
	}
	x++;
	
	 System.out.println(x);
	 
	//adds teachers lessons in a list
	String[] lessonsToTeach= PriorT.getLessonsCode().split("-");
	String[] hours =  PriorT.getMaxHours().split("_");
	//counts how many consecutive times same teacher is used
	System.out.println(PriorT);
	outerloop:
	//matches the vector of lessons with the lessons to teach
	
	for(int i = 0 ; i< parent.getvLessons().size();i++) {
		for(int z = 0; z<lessonsToTeach.length; z++) {
			if(lessonsToTeach[z] .equals(((Lessons) parent.getvLessons().get(i)).getCodeName())  ) {
				
				// if one available subject has 1 or more hours to be taught
				int tempInt = Integer.parseInt(((Lessons) parent.getvLessons().get(i)).getWeekHours());
				if(tempInt >0) {
					//finds the correct array to put in the subject
					for(int x = 0 ; x < parent.getStigmiotupo().size() ; x++) {
						if( parent.getStigmiotupo().get(x)[0][0].equals(((Lessons) parent.getvLessons().get(i)).getClassroom())  ) {
							//adds subject to array
							for(int t =1 ; t< parent.getStigmiotupo().get(x).length ; t++) {
								//makes sure that no more that  consecutive hours of the same subject is made
								for(int p = 0 ; p < parent.getStigmiotupo().get(x)[t].length ; p++ ) {
									if(t >= 2 &&  parent.getStigmiotupo().get(x)[t-1][p] != null &&  parent.getStigmiotupo().get(x)[t-2][p] != null ) {
										if(parent.getStigmiotupo().get(x)[t-1][p].equals(parent.getStigmiotupo().get(x)[t-2][p])){
										
										}
									}
									else if(parent.getStigmiotupo().get(x)[t][p] == null && PriorT.getAvailability(t-1) == true ) {
										parent.getStigmiotupo().get(x)[t][p] = ((Lessons) parent.getvLessons().get(i)).getName();
										parent.getStigmiotupo().get(x)[t][p] = PriorT.getName();
										PriorT.setAvailability(t-1, false);
										((Lessons) parent.getvLessons().get(i)).setWeekHours(String.valueOf(Integer.parseInt(((Lessons) parent.getvLessons().get(i)).getWeekHours())-1));
										// maxHours he can work -1
										int c = Integer.parseInt(hours[1]) -1 ;
										PriorT.setMaxHours(hours[0]+"_"+c);
										break outerloop;
									}
									
								}
								
							}
						 }
					 }
				 }
			}
		}
		
	}
	
	
	
	
	
	return parent.getStigmiotupo();

}}