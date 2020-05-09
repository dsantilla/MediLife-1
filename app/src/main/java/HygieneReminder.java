public class HygieneReminder extends Reminder {
    private String[] recommendedList = {"Brush teeth", "Floss teeth", "Take a shower", "Apply Deodorant", "Do skin routine"};
    public HygieneReminder()
    {
        super();
    }
    public HygieneReminder(String toDo, float timeToDo)
    {
        super(toDo, timeToDo);
    }

    public String[] getList()
    {
        return recommendedList;
    }
}
