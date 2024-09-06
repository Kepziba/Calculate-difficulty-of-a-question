import java.io.*;
import java.util.*;
public class Difficulty {  
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {  
    try {
      File file = new File("examly.txt");
      Scanner scanner = new Scanner(file);  
      while (scanner.hasNextLine()) {
        scanner.nextLine();
        scanner.nextLine();
        String questionData = scanner.nextLine();
        String data[]=questionData.split("-");
        int marksDifficulty=0;
        int timeDifficulty=0;
        int changesDifficulty=0;
        int hintsDifficulty=0;
        int manualDifficulty=0;
        int feedbackDifficulty=0;
        ArrayList<Integer> difficulty=new ArrayList<>();
        String difficultyRes="";
        LinkedHashMap<String,ArrayList> map=new LinkedHashMap<>();
        ArrayList<Double> a=new ArrayList<>();
        map.put("time",a);
        ArrayList<Integer> b=new ArrayList<>();
        map.put("changesOrCompilations",b);
        ArrayList<Integer> c=new ArrayList<>();
        map.put("hints",c);
        String type=data[0],manual=data[1];
        int attendedStudents=Integer.parseInt(data[2]);
        int index=2;
        for(int i=0;i<attendedStudents;i++){
          if(type.equals("MCQ")){
            for(int j=0;j<3;j++){
              index++;
              if(j==0){
                ArrayList<Double> arr=map.get("time");
                arr.add(Double.parseDouble(data[index]));
                map.put("time",arr);
              }
              if(j==1){
                ArrayList<Integer> arr=map.get("changesOrCompilations");
                arr.add(Integer.parseInt(data[index]));
                map.put("changesOrCompilations",arr);
              }
              if(j==2){
                ArrayList<Integer> arr=map.get("hints");
                arr.add(Integer.parseInt(data[index]));
                map.put("hints",arr);
              }
            }
          }
          else{
            for(int j=0;j<4;j++){
              String language;
              index++;
              if(j==0){
                ArrayList<Double> arr=map.get("time");
                arr.add(Double.parseDouble(data[index]));
                map.put("time",arr);
              }
              else if(j==1){
                ArrayList<Integer> arr=map.get("changesOrCompilations");
                arr.add(Integer.parseInt(data[index]));
                map.put("changesOrCompilations",arr);
              }
              else if(j==2){
                ArrayList<Integer> arr=map.get("hints");
                arr.add(Integer.parseInt(data[index]));
                map.put("hints",arr);
              }
              else if(j==3)
                language=data[index];
            }
          }
        }
        index++;
        String feedback="";
        if(attendedStudents!=0)
          feedback=data[index++];
        int right=Integer.parseInt(data[index++]);
        int wrong=Integer.parseInt(data[index++]);
        int partiallyCorrect=Integer.parseInt(data[index++]);
        int maximumMarks=Integer.parseInt(data[index++]);
        
        if(attendedStudents>0){
        double timeTaken=0.0;
        int numberOfChangesOrCompilations=0,numberOfHints=0;
        for(Map.Entry e:map.entrySet()){         
          if(e.getKey().equals("time")){
            ArrayList<Double> arr=(ArrayList<Double>)e.getValue();
            for(int i=0;i<arr.size();i++)
            timeTaken+=arr.get(i);
          }
          else if(e.getKey().equals("changesOrCompilations")){
            ArrayList<Integer> arr=(ArrayList<Integer>)e.getValue();
            for(int i=0;i<arr.size();i++)
              numberOfChangesOrCompilations+=arr.get(i);    
          }
          else if(e.getKey().equals("hints")){
            ArrayList<Integer> arr=(ArrayList<Integer>)e.getValue();
            for(int i=0;i<arr.size();i++)
              numberOfHints+=arr.get(i);    
          }         
        }
        double timeAverage=Double.parseDouble(String.format("%.2f",(timeTaken/(double)attendedStudents)));
        double changesAverage=Double.parseDouble(String.format("%.2f",(numberOfChangesOrCompilations/(double)attendedStudents)));
        double hintsAverage=Double.parseDouble(String.format("%.2f",(numberOfHints/(double)attendedStudents)));
      
        //Diff : 1 , 2
      if(type.equalsIgnoreCase("MCQ")){
        if(manual.equalsIgnoreCase("Easy"))
          timeDifficulty=(timeAverage<=1.0)?1:((timeAverage<=1.5)?2:3);
        else if(manual.equalsIgnoreCase("Medium"))
          timeDifficulty=(timeAverage<=1.6)?1:((timeAverage<=2.0)?2:3);
        else
          timeDifficulty=(timeAverage<=2.0)?1:((timeAverage<=3.0)?2:3);
        changesDifficulty=(changesAverage<2)?1:((changesAverage==2)?2:3);
        }
      else{
          if(manual.equalsIgnoreCase("Easy")){
            timeDifficulty=(timeAverage<=6)?1:((timeAverage<=12)?2:3);
            changesDifficulty=(changesAverage<=3)?1:((changesAverage<=6)?2:3);
          }
          else if(manual.equalsIgnoreCase("Medium")){
            timeDifficulty=(timeAverage<=18)?1:((timeAverage<=28)?2:3);
            changesDifficulty=(changesAverage<=6)?1:((changesAverage<=12)?2:3);
          }
          else{
            timeDifficulty=(timeAverage<=22)?1:((timeAverage<=33)?2:3);
            changesDifficulty=(changesAverage<=10)?1:((changesAverage<=20)?2:3);
          }
        }
        difficulty.add(timeDifficulty);
        difficulty.add(changesDifficulty);
        
        //Diff : 3
        if(manual.equalsIgnoreCase("Easy"))
        hintsDifficulty=(hintsAverage<3)?1:((hintsAverage==3)?2:3);
        else if(manual.equalsIgnoreCase("Medium"))
        hintsDifficulty=(hintsAverage<5)?1:((hintsAverage==5)?2:3);
        else
          hintsDifficulty=(hintsAverage<7)?1:((hintsAverage==7)?2:3);
        difficulty.add(hintsDifficulty);
      
        //Diff : 4
        feedbackDifficulty=(feedback.equalsIgnoreCase("Easy"))?1:((feedback.equalsIgnoreCase("Medium"))?2:3);
        difficulty.add(feedbackDifficulty);

        //Diff : 5
        int marks=attendedStudents*maximumMarks;
        double attendedStudentMarks=(right*maximumMarks)+((partiallyCorrect)*(maximumMarks/2));
        marksDifficulty=(attendedStudentMarks<=(marks/3.0))?3:((attendedStudentMarks<=((marks/3.0)*2)?2:1));
        difficulty.add(marksDifficulty);
        }  
        //Diff : 6
        manualDifficulty=(manual.equalsIgnoreCase("Easy"))?1:((manual.equalsIgnoreCase("Medium"))?2:3);
        difficulty.add(manualDifficulty);
        //Calculating difficulty of the question
        double easyDifficulty=(Collections.frequency(difficulty,1))*1;
        double mediumDifficulty=(Collections.frequency(difficulty,2))*2;
        double hardDifficulty=(Collections.frequency(difficulty,3))*3;
        
        if(easyDifficulty>mediumDifficulty && easyDifficulty>hardDifficulty)
          difficultyRes="Easy";
        else if(mediumDifficulty>easyDifficulty && mediumDifficulty>hardDifficulty)
          difficultyRes="Medium";
        else if(easyDifficulty==2 && mediumDifficulty==4 && hardDifficulty==6)
              difficultyRes="Medium";
        else if(hardDifficulty>easyDifficulty && hardDifficulty>mediumDifficulty){
          if(Collections.frequency(difficulty,3)==Collections.frequency(difficulty,1))
            difficultyRes="Medium";
          else if(Collections.frequency(difficulty,3)>=(6/2))
            difficultyRes="Hard";
          else if(Collections.frequency(difficulty,2)>0)
            difficultyRes="Medium";
          else  
          difficultyRes="Hard";
        } 
        else if(easyDifficulty==mediumDifficulty)
            difficultyRes="Easy";
        else if(easyDifficulty==hardDifficulty)
          difficultyRes="Medium";
        else if(mediumDifficulty==hardDifficulty)
          difficultyRes="Hard";
          
        System.out.println(difficultyRes);
        System.out.println();
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found!");
      e.printStackTrace();
    } 
  }  
}