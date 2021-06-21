interface Char380{
    public void zaradka();
}
interface Char380Rus{
    public void zaradka220();
}

class Zr380 implements Char380{

    @Override
    public void zaradka(){
        System.out.println("Включена зарядка 380 ");
    }

}

class Z220 implements Char380Rus{

    @Override
    public void zaradka220(){ System.out.println("Включена зарядка 220");
    }

}

class CharAdapter220 implements Char380{
    Char380Rus Char380Rus;
    public CharAdapter220(Char380Rus Char380Rus){

        this.Char380Rus = Char380Rus;
    }


    @Override
    public void zaradka(){
        Char380Rus.zaradka220();
    }

}

class CentralProcessor{
    private Char380 telefon;
    public CentralProcessor(Char380 telefon){
        this.telefon = telefon;
    }

    public void work(){

        telefon.zaradka();
    }
}

public class LAb16{
    public static void main(String[] args){
//создаем объект зарядку
        Char380 z380 = new Zr380();
//создаем объект процессора и передаем ему в управления зарядку
        CentralProcessor cp = new CentralProcessor(z380);
//процессор управляет работой машины
        cp.work();

//cсоздаем адаптер и передаем
        CharAdapter220 z220 = new CharAdapter220(new Z220());
//создаем процессор и передаем в него адаптер
        CentralProcessor cpRus = new CentralProcessor(z220);
        cpRus.work();
    }
}