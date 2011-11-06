package home.edu.pack;

import java.io.Serializable;
import java.util.List;

import home.edu.util.AppUtil;
import home.edu.util.MessageUtil;

public class CommonMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected byte[] data = {};

	public CommonMessage() {
		process();
	}

	public CommonMessage(byte[] data) {
		this.data = data;
		process();
	}

	public CommonMessage(byte[] data, boolean unpack) {
		this.data = data;
		if (!unpack) {
			process();
		}

	}

	public byte[] pack() {
		return data;
	}

	public byte[] unpack() {
		List<byte[]> list = MessageUtil.cutByteArray(data, 2);
		return list.get(1);
	}

	protected void process() {
		long dataLen = data.length;
		byte[] lenBytes = MessageUtil.bindToHead(
				MessageUtil.longToByteArray(dataLen), data);
		this.data = lenBytes;
	}
}
