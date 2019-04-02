/*
In this problem, there are types of events: ENTER (a student enters the queue) or SERVED.
A unique token is assigned to any student entering the queue. The queue serves the students 
based on the following criteria:
The student having the highest Cumulative Grade Point Average (CGPA) is served first.
Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
Any students having the same CGPA and name will be served in ascending token order.
Given a sequence of  events, print the names of students who are yet to be served(based on above criteria). 
If the queue is empty, print EMPTY.
Input Format
The first line of input contains an integer, , denoting the total number of events. 
Each of the subsequent lines will be of the following two forms:
ENTER name CGPA token - The student to be inserted into the priority queue.
SERVED - The highest priority student in the queue was served.
Constraints
 where 
 where each token i is a unique integer.

Output Format
Print the names (based on the criteria) of the students who are not served at all after executing all  events; if every student in the queue was served, then print EMPTY.
Sample Input
12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED
Sample Output
Dan
Ashley
Shafaet
Maria
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Student{
   int tokenNo;
   String Sname;
   double cgpa;
   public Student(int id, String Sname, double cgpa) {
      this.tokenNo = id;
      this.Sname = Sname;
      this.cgpa = cgpa;
   }
   public String getSname() {
      return Sname;
   }
   public int compareTo(Student s)
   {
       if(this.cgpa < s.cgpa)
           return -1;
       else if (this.cgpa > s.cgpa)
            return 1; 
       if(this.Sname.compareTo(s.Sname) > 0)
           return -1;
       else if(this.Sname.compareTo(s.Sname) < 0)
           return 1;
       else
            if(this.tokenNo<s.tokenNo)
               return -1;
       return 1;
   }
}

class StudentsQueue
{

    public static ArrayList<Student> studentQueue = new ArrayList<>();
    public static void insertStudent(Student s)
    {
        int position=0;
        for(int i = 0;i < studentQueue.size() ;i++)
        {
            if(studentQueue.get(position).compareTo(s)>0)
                position= i+1;
            else
                break;
        }
        studentQueue.add(position,s);
    }
    
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = Integer.parseInt(sc.nextLine());
      while(t>0)
      {
        String[] arr = sc.nextLine().split(" ");
        if(arr.length == 1){
            if(!studentQueue.isEmpty())
                studentQueue.remove(0);
        }
        else
        {
            int token=Integer.parseInt(arr[3]);
            double gpa=Double.parseDouble(arr[2]);
            Student s = new Student(token,arr[1],gpa);
            insertStudent(s);
        }      
         t--;
      }
        if(studentQueue.size()!=0)
        {
            for(int i = 0;i <studentQueue.size();i++)
                System.out.println(studentQueue.get(i).getSname());
        }
        else
            System.out.println("EMPTY");
    }
}
