package fr.husta.test.ex7;

/**
 *
 */
public class MyPojo
{

    @CheckCustomMessage
    private String name;

    public MyPojo()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
