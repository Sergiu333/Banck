import java.util.*;
import java.io.*;

class Banca{

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
        ArrayList<Banca> rezultat = new ArrayList<Banca>();
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
            if(banca.procent<=p)
                if(banca.valuta.equals(val))
                    if (banca.sumMax>=sum)
                        rezultat.add(banca);

        }
        filescan.close();

        return rezultat;

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

    static ArrayList<Credit> detalii(int per) throws IOException //per--perioada (luna)
    {
        //de ceea sa creat obectul filescan
        ArrayList<Credit> cr = new ArrayList<Credit>();
        Scanner filescan=new Scanner(new FileReader("Credite.txt"));
        while(filescan.hasNext())
        {
            Credit credit = new Credit();

            credit.tip=filescan.next();
            credit.perioada=filescan.nextInt();

            //dupa ce u fost citite datele se afiseaza cu ajutorul functiei toString.
            cr.add(credit);


        }
        filescan.close();
        return cr;
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

 //Java String equalsIgnoreCase().

            //           System.out.println(super.companie);
            //       System.out.println("Dvs aveti salariul : "+cerere.salariu+" si optiunea optima este de la banca : ");
            if(cerere.salariu>=8000){
                System.out.print("-procent: ");
                int p=cin.nextInt();
                System.out.print("-valuta: ");
                String val=cin.next();
                System.out.print("-suma dorita: ");
                int sum=cin.nextInt();
                System.out.print("-perioada: ");
                int per=cin.nextInt();

                ArrayList<Banca> banci = Banca.citireOptim(p,val,sum);
                ArrayList<Credit> credite =Credit.detalii(per);
                //Sumele*procente

                System.out.println("Setul de oferte: ");
                int i;
                for(i=0;i<banci.size();i++) {

                    System.out.print("Oferta "+(i+1)+": "+(sum+
                            ((sum*(banci.get(i).procent+per))/100))+" !!"+" "+banci.get(i).companie);
                    System.out.print(" !! adaos: "+banci.get(i).procent);
                    for(int j=0;j<credite.size();j++){

                        if(per==credite.get(j).perioada){
                            System.out.println(" !! Tip credit: "+credite.get(j).tip);
                        }

                    }

                }if(i==0)
                    System.out.println("-Nu exista oferte dupa cerintele Dvs.");
            }
            else{
                System.out.println("Dvs aveti salariul de :"+cerere.salariu+" lei cererea a fost repinsa!");
            }
        }
        filescan.close();

    }

    public  void Tabel() throws IOException{
        System.out.println("<<Tabel>>");
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



            //           System.out.println(super.companie);
            //       System.out.println("Dvs aveti salariul : "+cerere.salariu+" si optiunea optima este de la banca : ");
            if(cerere.salariu>=8000){
                System.out.print("-procent: ");
                int p=cin.nextInt();
                System.out.print("-valuta: ");
                String val=cin.next();
                System.out.print("-suma dorita: ");
                int sum=cin.nextInt();
                System.out.print("-perioada: ");
                int per=cin.nextInt();


                ArrayList<Banca> banci = Banca.citireOptim(p,val,sum);
                ArrayList<Credit> credite =Credit.detalii(per);


                System.out.println("Setul de oferte: ");
                int i;
                for(i=0;i<banci.size();i++) {

                    System.out.print("Tabelul "+(i+1)+": "+(sum+
                            ((sum*(banci.get(i).procent+per))/100))+" !!"+" "+banci.get(i).companie);

                    System.out.print(" !! procentul: "+banci.get(i).procent);

                    System.out.print(" plata luna: "+(sum+((sum*(banci.get(i).procent))/100))/per);

                    System.out.print(" suma disponibila: "+cerere.salariu*5);

                    if(cerere.salariu*5 >=sum)
                        System.out.println(" admis");
                    else System.out.println(" respins");

                }if(i==0)
                    System.out.println("-Nu exista oferte dupa cerintele Dvs.");
            }
            else{
                System.out.println("Dvs aveti salariul de :"+cerere.salariu+" lei cererea a fost repinsa!");
            }
        }
        filescan.close();

    }

}

class Antifrauda extends Banca{
    String numeBanca,numeSesizare;
    int nivelSecuritate;
    public Antifrauda(){}
    public Antifrauda(String numeBanca,String numeSesizare,int nivelSecuritate){
        this.numeBanca=numeBanca;
        this.numeSesizare=numeSesizare;
        this.nivelSecuritate=nivelSecuritate;
    }

    public String toString(){
        return numeBanca+" "+numeSesizare+" "+nivelSecuritate;
    }

    static void initializare()throws IOException {

        FileWriter fw=new FileWriter("Antifrauda.txt",true);

        Scanner cin =new Scanner(System.in);

        Antifrauda sistem = new Antifrauda();

        System.out.println("Introdu un Sistem : ");
        System.out.print("-numeBanca : ");
        sistem.numeBanca=cin.next();
        System.out.print("-numeSesizare : ");
        sistem.numeSesizare=cin.next();
        System.out.print("-nivelSecuritate : ");
        sistem.nivelSecuritate=cin.nextInt();


        System.out.println("\n Sistemul a fost adaugat cu succes !");


        fw.append(sistem.toString()+'\n');// append adauga la sfirsit lista recent introdusa
        fw.close();
    }

    static void citire() throws IOException
    {

        Scanner filescan=new Scanner(new FileReader("Antifrauda.txt"));
        System.out.println("<<Lista>>: ");
        while(filescan.hasNext())
        {
            Antifrauda sistem= new Antifrauda();



            sistem.numeBanca=filescan.next();
            sistem.numeSesizare=filescan.next();
            sistem.nivelSecuritate=filescan.nextInt();

            //dupa ce u fost citite datele se afiseaza cu ajutorul functiei toString.
            System.out.println(sistem.toString());


        }
        filescan.close();

    }

}

class Promotii extends Banca{
    int id,procenteReduse;

    Promotii(){}

    Promotii(int id,int procenteReduse){
        this.id=id;
        this.procenteReduse=procenteReduse;
    }

    public String toString(){
        return id+" "+procenteReduse;
    }

    static void initializare()throws IOException {

        FileWriter fw=new FileWriter("Promotii.txt",true);

        Scanner cin =new Scanner(System.in);

        Promotii promotie = new Promotii();

        System.out.println("Introdu o noua promotie : ");
        System.out.print("-id : ");
        promotie.id=cin.nextInt();
        System.out.print("-procenteReduse : ");
        promotie.procenteReduse=cin.nextInt();


        System.out.println("\n Promotia a fost adaugat cu succes !");


        fw.append(promotie.toString()+'\n');// append adauga la sfirsit lista recent introdusa
        fw.close();
    }

    static void citire() throws IOException
    {
        System.out.println("<<Lista>>: ");
        Scanner filescan=new Scanner(new FileReader("Promotii.txt"));
        while(filescan.hasNext())
        {
            Promotii promotie = new Promotii();



            promotie.id=filescan.nextInt();
            promotie.procenteReduse=filescan.nextInt();


            //dupa ce u fost citite datele se afiseaza cu ajutorul functiei toString.
            System.out.println(promotie.toString());


        }
        filescan.close();

    }


    static void citirePro() throws IOException
    {
        System.out.println("<<Lista>>: ");
        Scanner filescan=new Scanner(new FileReader("Promotii.txt"));
        while(filescan.hasNext())
        {
            Promotii promotie = new Promotii();
            Scanner cin =new Scanner(System.in);


            promotie.id=filescan.nextInt();
            promotie.procenteReduse=filescan.nextInt();
            int idb=cin.nextInt();
            ArrayList<Credit> credite =Credit.detalii(idb);


            for(int i=0;i<credite.size();i++){

                System.out.println("Promotia "+(i+1)+": "+" "+credite.get(i).tip+" redus cu: "+promotie.procenteReduse+" %");


            }



        }
        filescan.close();

    }

}

class Test  {



    public static void main(String []args)throws IOException{
        int varianta=1;
        Scanner v =new Scanner(System.in);
        do{
            System.out.println("\n+-------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                 Meniu                                                       |");
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
            System.out.println("| 1) Afisarea ofertelor :                                                                                     |");
            System.out.println("| 2) Banca optima :                                                                                           |");
            System.out.println("| 3) Tabelul :                                                                                                |");
            System.out.println("| 4) *Securitate :                                                                                            |");
            System.out.println("| 5) *Promotii   :                                                                                            |");
            System.out.println("| 0) EXIT:                                                                                                    |");
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
            System.out.print("Raspuns : ");
            varianta=v.nextInt();
            System.out.println();



            switch(varianta){
                case 1:Banca.citire();break;
                case 2:Cerere z =new Cerere();
                    z.Optim();break;
                case 3: Cerere obj = new Cerere();
                    obj.Tabel();break;
                case 4: Antifrauda.citire(); break;
                case 5: Promotii.citirePro();break;
                case 6:Cerere.citire();break;
                case 7:Credit.initializare();break;
                case 8:Cerere.initializare();break;
                case 9:
                    Banca c = new Banca();
                    Scanner cin = new Scanner(System.in);
                    System.out.println("Nr de banci care doriti sal introduceti : ");
                    int nr =cin.nextInt();

                    for(int i=0; i<nr; i++)
                    {
                        Banca.initializare();
                    }

                    break;
                case 10: Antifrauda.initializare(); break;
                case 11: Promotii.initializare();break;
                case 12:Credit.citire();break;


            }
        }while(varianta!=0);
        System.out.println("programul a luat sfirsit");

    }

}