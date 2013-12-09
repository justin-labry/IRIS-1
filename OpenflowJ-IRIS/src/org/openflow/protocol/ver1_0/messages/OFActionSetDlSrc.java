package org.openflow.protocol.ver1_0.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_0.types.*;

public class OFActionSetDlSrc extends OFAction  {
    public static int MINIMUM_LENGTH = 16;

    byte[]  dl_addr;
	int pad_1th;
	short pad_2th;

    public OFActionSetDlSrc() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFActionType.valueOf((short)4));
		dl_addr = new byte[6];
    }
    
    public OFActionSetDlSrc(OFActionSetDlSrc other) {
    	super(other);
		if (other.dl_addr != null) { this.dl_addr = java.util.Arrays.copyOf(other.dl_addr, other.dl_addr.length); }
    }

	public byte[] getDlAddr() {
		return this.dl_addr;
	}
	
	public OFActionSetDlSrc setDlAddr(byte[] dl_addr) {
		this.dl_addr = dl_addr;
		return this;
	}
			

    public void readFrom(ByteBuffer data) {
        super.readFrom(data);
		if ( this.dl_addr == null ) this.dl_addr = new byte[6];
		data.get(this.dl_addr);
		this.pad_1th = data.getInt();
		this.pad_2th = data.getShort();
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        if ( this.dl_addr != null ) { data.put(this.dl_addr); }
		data.putInt(this.pad_1th);
		data.putShort(this.pad_2th);
    }

    public String toString() {
        return super.toString() +  ":OFActionSetDlSrc-"+":dl_addr=" + java.util.Arrays.toString(dl_addr);
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)MINIMUM_LENGTH;
    	if ( this.dl_addr != null ) { len += this.dl_addr.length; } 
    	return len;
    }
    
    // calculate the amount that will be increased by the alignment requirement.
    public short alignment(short req) {
    	short l = (short)(computeLength() % req);
    	if ( l == 0 ) { return 0; }
    	return (short)( req - l );
    }
    
    // compute the difference with MINIMUM_LENGTH (with alignment)
    public short lengthDiff() {
    	return (short)(computeLength() - (short)MINIMUM_LENGTH + alignment((short)0));
    }

    @Override
    public int hashCode() {
        		
		final int prime = 2803;
		int result = super.hashCode() * prime;
		result = prime * result + ((dl_addr == null)?0:java.util.Arrays.hashCode(dl_addr));
		return result;
    }

    @Override
    public boolean equals(Object obj) {
        
		if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof OFActionSetDlSrc)) {
            return false;
        }
        OFActionSetDlSrc other = (OFActionSetDlSrc) obj;
		if ( dl_addr == null && other.dl_addr != null ) { return false; }
		else if ( !java.util.Arrays.equals(dl_addr, other.dl_addr) ) { return false; }
        return true;
    }
}
