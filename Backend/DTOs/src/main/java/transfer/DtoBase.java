package transfer;

public class DtoBase {
    private long _id;


    public DtoBase( long id ) throws Exception
    {
        setId( id );
    }

    public DtoBase()
    {
    }

    public long getId()
    {
        return _id;
    }

    public void setId( long id )
    {
        if ( id >= 0 )
        {
            _id = id;
        }
        else
        {
            System.out.println("error");
        }
    }
}
