package testingCode;

/**
 * Example vertex class used for testing
 */
public class ExampleVertex {
    /**
     * id of the vertex, main identifier
     */
    private long id;
    /**
     * Description of the vertex
     */
    private String description;

    public ExampleVertex(long id, String description){
        this.id = id;
        this.description = description;
    }

    /**
     * returns the id of the vertex
     * @return id of the vertex
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id of the vertex
     * @param id new id to be set to
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the description of the vertex
     * @return  description of the vertex
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the vertex
     * @param description description to be set to
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return id + "";
    }
}
