public class CustomReminder extends Reminder {
    private String[] recommendedList = {"Eat Breakfast", "Drink water", "Take a nap", "Have a healthy snack"};
    public CustomReminder()
    {
        super();
    }
    public CustomReminder(String toDo, float timeToDo)
    {
        super(toDo, timeToDo);
    }

    public String[] getList()
    {
        return recommendedList;
    }
}
