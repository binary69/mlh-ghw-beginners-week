//Pet class
class Pet{
    private String name;
    private int happiness;
    private int hunger;

    Pet(String name){
        this.name = name;
        this.happiness = 50;
        this.hunger = 50;
    }

    public void passTime(){
        hunger = Math.min(100, hunger+10);
        happiness = Math.max(0, happiness-5);
    }

    public void feed(){
        hunger = Math.max(0, hunger-15);
        System.out.println("You just fed " + this.name + "!");
        passTime();
    }

    //method to play with the pet
    public void play(){
        if(hunger>90) System.out.println("Too hungry, can't play now");
        else{
            happiness = Math.min(100, happiness+15);
            hunger = Math.min(100, hunger + 15);
            passTime();
        }
    }

    public void getStatus(){
        System.out.println("Happiness of " + this.name + " is: " + this.happiness);
        System.out.println("Hunger of " + this.name + " is: " + this.hunger);
    }
}