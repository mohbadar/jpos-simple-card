package com.hqsolution.hqserver.app.pack;

import java.io.IOException;
import java.util.List;

import com.hqsolution.hqserver.app.util.MessageUtil;

/**
 * 
 * @author Anh Quan
 * 
 */
public class ObjectUnPackMessage extends CommonUnPackMessage {

	private Object obj;
	private short objectType;
	private int objLength;

	public ObjectUnPackMessage(byte[] data) {
		super(data);
	}

	/**
	 * Unpack to raw Object
	 * 
	 * @return Object raw object
	 */
	public Object unpackObject() {
		if (obj != null) {
			return obj;
		}
		try {
			// get type(2 bytes) - len (4 bytes)- object
			byte[] ba = unpack();
			List<byte[]> list = MessageUtil.cutByteArray(ba, 2);
			this.objectType = MessageUtil.byteArrayToShort(list.get(0));
			byte[] tmpObjAndLen = list.get(1);
			list = MessageUtil.cutByteArray(tmpObjAndLen, 4);
			this.objLength = MessageUtil.byteArrayToInt(list.get(0));
			byte[] obj = list.get(1);
			this.obj = MessageUtil.convertByteArrayToObject(obj);
			return this.obj;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

		}
		return null;
	}

	public short getObjectType() {
		return objectType;
	}

	public int getObjLength() {
		return objLength;
	}

	public Object getObj() {
		return obj;
	}
}