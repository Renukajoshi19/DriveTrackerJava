package Com.tq.Jsonutil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class convert_j_to_java_and_java_to_j {
	private static final ObjectMapper mapper = new ObjectMapper();

	public static Object getObjectFromJSON(String jsonString, Class<?> className) 
	{
		Object rd = null;
		
		System.out.println(jsonString);

		try 
		{
			rd = mapper.readValue(jsonString, className);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return rd;
	}

	public static String getJSONFromObject(Object object) {
		String jsonData = null;

		try {
			jsonData = mapper.writeValueAsString(object);

		} catch (Exception e) {
			System.out.println("Error in  getJSONFromObject " + e);
		}
		return jsonData;
	}
}
