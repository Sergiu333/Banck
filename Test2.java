import java.util.*;
import java.io.*;

class Banca{
	public int sergiu=333;                                                                                                               
	public String companie, adresa, valuta,telefon, e_mail;
	public int id, procent, sumMax ;

	Banca(){

	}

	Banca(int id , String companie, String adresa, String valuta ,int procent,String telefon ,
		String e_mail,int sumMax){
		this.id=id;
		this.companie=companie;
		this.adresa=adresa;
		this.valuta=valuta;
		this.procent=procent;
		this.telefon=telefon;
		this.e_mail=e_mail;
		this.sumMax=sumMax;
	}

	public  String toString(){
		return id+" "+companie+" "+adresa+" "+valuta+" "+procent+" "+telefon+" "+e_mail+" "+sumMax;
	}

	public int getId(){
		return id;
	}

	public String getCompanie(){
		return companie;
	}

	public String getAdresa(){
		return adresa;
	}

	public String getValuta(){
		return valuta;
	}

	public int getProcent(){
		return procent;
	}

	public String gettelefon(){
		return telefon;
	}

	

	public int  getsumMax(){
		return sumMax=30000;
	}


 static void initializare()throws IOException {

		FileWriter fw=new FileWriter("Banci.txt",true);

        Scanner cin =new Scanner(System.in);

        Banca banca = new Banca();
        
        System.out.println("Introdu o noua banca  : ");
        System.out.print("-id-ul : ");
        banca.id=cin.nextInt();
        System.out.print("-Banca : ");
        banca.companie=cin.next();
        System.out.print("-adresa: ");
        banca.adresa=cin.next();
        System.out.print("-valuta : ");
        banca.valuta=cin.next();
        System.out.print("-procent : ");
        banca.procent=cin.nextInt();
        System.out.print("-telefon : ");
        banca.telefon=cin.next();
        System.out.print("e-mail : ");
        banca.e_mail=cin.next();
        System.out.print("suma maxima : ");
        banca.sumMax=cin.nextInt();
        
        System.out.println("\n"+banca.id+" "+banca.companie+" a fost adaugat cu succes !");


        fw.append(banca.toString()+'\n');// append adauga la sfirsit lista recent introdusa
        fw.close();
    }


    static void citire() throws IOException
    {   
        //de ceea sa creat obectul filescan 
        Scanner filescan=new Scanner(new FileReader("Banci.txt"));
        while(filescan.hasNext())
        {
            Banca banca = new Banca();
            Scanner cin =new Scanner(System.in);
            
	       
	        banca.id=filescan.nextInt();
	       	banca.companie=filescan.next();
	        banca.adresa=filescan.next();
	        banca.valuta=filescan.next();
	        banca.procent=filescan.nextInt();
	        banca.telefon=filescan.next();
	        banca.e_mail=filescan.next();
	        banca.sumMax=filescan.nextInt();

            //dupa ce u fost citite datele se afiseaza cu ajutorul functiei toString.
            
            System.out.println(banca.toString());

        }
        filescan.close();

    }


    static ArrayList<Banca> citireOptim(int p,String val,int sum) throws IOException
    {   
        //de ceea sa creat obectul filescan 
        ArrayList<Banca> result = new ArrayList<>();
        Scanner filescan=new Scanner(new FileReader("Banci.txt"));
        while(filescan.hasNext())
        {
            Banca banca = new Banca();
            Scanner cin =new Scanner(System.in);
            
	       
	        banca.id=filescan.nextInt();
	       	banca.companie=filescan.next();
	        banca.adresa=filescan.next();
	        banca.valuta=filescan.next();
	        banca.procent=filescan.nextInt();
	        banca.telefon=filescan.next();
	        banca.e_mail=filescan.next();
	        banca.sumMax=filescan.nextInt();

            //dupa ce u fost citite datele se afiseaza cu ajutorul functiei toString.
            if(banca.procent<=p)
            if(banca.valuta.equals(val))
            if (banca.sumMax>=sum)
            //System.out.println(banca.toString());
            result.add(banca);
        }
        filescan.close();
        return result;

    }

}


class Credit extends Banca{

	public String tip;
	public int perioada; 
	
	
	Credit(){

	}

	Credit(String tip, int perioada){

		this.tip=tip;
		this.perioada=perioada;
	}

	public String toString(){
		return tip+" "+perioada;
	}

	

 static void initializare()throws IOException {

		FileWriter fw=new FileWriter("Credite.txt",true);

        Scanner cin =new Scanner(System.in);

        Credit credit = new Credit();
        
        
        System.out.print("-tip : ");
        credit.tip=cin.next();
        System.out.print("-perioada: ");
        credit.perioada=cin.nextInt();
        
        
        
        System.out.println("\n A fost adaugat cu succes !");


        fw.append(credit.toString()+'\n');// append adauga la sfirsit lista recent introdusa
        fw.close();
    }

	
	static void citire() throws IOException
    {   
        //de ceea sa creat obectul filescan 
        Scanner filescan=new Scanner(new FileReader("Credite.txt"));
        while(filescan.hasNext())
        {
            Credit credit = new Credit();
                        	       
	        credit.tip=filescan.next();
	        credit.perioada=filescan.nextInt();

            //dupa ce u fost citite datele se afiseaza cu ajutorul functiei toString.
            System.out.println(credit.toString());


        }
        filescan.close();

    }

}


class Cerere extends Credit{

	public int id,anul_nasterii;
	public String nume,prenume,patronimic , adresa, post_de_munca, telefon ;
	public String gen;
	public int salariu;

	Cerere(){

		}

	Cerere(int id,String nume,String prenume,String patronimic, String gen,int anul_nasterii, 
		    String post_de_munca,int salariu, String telefon){
		
		this.id=id;
		this.nume=nume;
		this.prenume=prenume;
		this.patronimic=patronimic;
		this.gen=gen;
		this.anul_nasterii=anul_nasterii;
		this.post_de_munca=post_de_munca;
		this.salariu=salariu;
		this.telefon=telefon;

	}

	public String toString(){
		return id+" "+nume+" "+prenume+" "+patronimic+" "+gen+" "+anul_nasterii
		+" "+post_de_munca+" "+salariu+" "+telefon;
	}



	public int getid(){
		return id;
	}

	public String getNume(){
		return nume;
	}

	public String getPrenume(){
		return prenume;
	}

	public String getPatronimic(){
		return patronimic;
	}

	public String getGet(){
		return gen;
	}

	public int anul_nasterii(){
		return anul_nasterii;
	}

	public String getPost_de_munca(){
		return post_de_munca;
	}

	public static void getSalariu(){
		System.out.println("salariu");
	}


	 static void initializare()throws IOException {

		FileWriter fw=new FileWriter("Cereri.txt",true);

        Scanner cin =new Scanner(System.in);

        Cerere cerere = new Cerere();
        
        System.out.println("Introdu o noua cerere : ");
        System.out.print("-id : ");
        cerere.id=cin.nextInt();
        System.out.print("-nume : ");
        cerere.nume=cin.next();
        System.out.print("-prenume : ");
        cerere.prenume=cin.next();
        System.out.print("-patronimic : ");
        cerere.patronimic=cin.next();
        System.out.print("-gen : ");
        cerere.gen=cin.next();
        System.out.print("-anul_nasterii : ");
        cerere.anul_nasterii=cin.nextInt();
        System.out.print("-post_de_munca : ");
        cerere.post_de_munca=cin.next();
        System.out.print("-salariu : ");
        cerere.salariu=cin.nextInt();
        System.out.print("-telefon : ");
        cerere.telefon=cin.next();
        
        
        
        System.out.println("\n Cererea a fost adaugat cu succes !");


        fw.append(cerere.toString()+'\n');// append adauga la sfirsit lista recent introdusa
        fw.close();
    }

      static void citire() throws IOException
     {   
         
        Scanner filescan=new Scanner(new FileReader("Cereri.txt"));
        while(filescan.hasNext())
        {
            Cerere cerere = new Cerere();
            
            	       
	    System.out.println("<<Lista>>: ");
        cerere.id=filescan.nextInt();
        cerere.nume=filescan.next();
        cerere.prenume=filescan.next();
        cerere.patronimic=filescan.next();
        cerere.gen=filescan.next();
        cerere.anul_nasterii=filescan.nextInt();
        cerere.post_de_munca=filescan.next();
        cerere.salariu=filescan.nextInt();
        cerere.telefon=filescan.next();

            //dupa ce u fost citite datele se afiseaza cu ajutorul functiei toString.
            System.out.println(cerere.toString());


        }
        filescan.close();

    }


       public  void Optim() throws IOException{
          System.out.println("<<Optim>>");
          Scanner filescan=new Scanner(new FileReader("Cereri.txt"));
        while(filescan.hasNext())
        {
            Cerere cerere = new Cerere();
            Scanner cin =new Scanner(System.in);
            	       
	    
        cerere.id=filescan.nextInt();
        cerere.nume=filescan.next();
        cerere.prenume=filescan.next();
        cerere.patronimic=filescan.next();
        cerere.gen=filescan.next();
        cerere.anul_nasterii=filescan.nextInt();
        cerere.post_de_munca=filescan.next();
        cerere.salariu=filescan.nextInt();
        cerere.telefon=filescan.next();
         
         

         	
            System.out.println(super.companie);
            System.out.println("Dvs aveti salariul : "+cerere.salariu+" si optiunea optima este de la banca : ");
          	System.out.print("procent: ");
	        int p=cin.nextInt();
	        System.out.print("valuta: ");
	        String val=cin.next();
	        System.out.print("suma dorita:");
	        int sum=cin.nextInt();
          	
          	ArrayList<Banca> banci = Banca.citireOptim(p,val,sum);
          	
        }
        filescan.close();
          
          
    

         }
         public void hz(){
         	System.out.println(super.sergiu+1);
         }

}



class Test2  {


    
    public static void main(String []args)throws IOException{
		int varianta=1;
		 Scanner v =new Scanner(System.in);
    	do{
    		System.out.println("\n+-------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                 Meniu                                                       |");
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
            //System.out.println("| 1) Initializarea unei Banci :                                                                               |");
            //System.out.println("| 2) Initializarea unui Credit :                                                                              |");
            //System.out.println("| 3) Initializarea unei Cerere :                                                                              |");
            //System.out.println("| 4) Afisarea datelor bancilor :                                                                              |");
            //System.out.println("| 5) Afisarea datelor Creditelor :                                                                            |");
           // System.out.println("| 6) Afisarea datelor Cererilor :                                                                             |");
            System.out.println("| 7) Banca optima :                                                                                           |");
            System.out.println("| 0) EXIT:                                                                                                    |");
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
            System.out.print("Raspuns : ");
            varianta=v.nextInt();
            System.out.println();

    	
    
    	switch(varianta){
    		case 1:
    		Banca c = new Banca();
                Scanner cin = new Scanner(System.in);
                System.out.println("Nr de banci care doriti sal introduceti : ");
                int nr =cin.nextInt();

                for(int i=0; i<nr; i++)
                {
                    Banca.initializare();
                }
                
    			 break;
    		 
    		 	 case 2:Credit.initializare();break;
                 case 3:Cerere.initializare();break;
                 case 4:Banca.citire();break;
                 case 5:Credit.citire();break;
                 case 6:Cerere.citire();break;
                 case 7:
                 Cerere z =new Cerere();
                 z.Optim();break;

    	}
   }while(varianta!=0);
    System.out.println("programul a luat sfirsit");

    }

}