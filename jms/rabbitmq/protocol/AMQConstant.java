package jms.rabbitmq.protocol;

import java.util.HashMap;
import java.util.Map;


import jms.rabbitmq.framing.AMQShortString;


public final class AMQConstant {

	/** Defines a map from codes to constants. */
    private static Map<Integer, AMQConstant> _codeMap = new HashMap<Integer, AMQConstant>();

	/** Indicates that the method completed successfully. */
    public static final AMQConstant CONNECTION_FAIL = new AMQConstant(501, "connection fail", true);
    
	private int _code;
	
	private AMQShortString _name;
    
    /**
     * @param code
     * @param name
     * @param map
     */
    public AMQConstant(int code, String name, boolean map) {
    	 _code = code;
         _name = new AMQShortString(name);
         if (map)
         {
             _codeMap.put(Integer.valueOf(code), this);
         }
  	}
}
