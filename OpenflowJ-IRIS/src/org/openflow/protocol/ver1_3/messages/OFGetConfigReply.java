package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_3.types.*;

public class OFGetConfigReply extends OFMessage  {
    public static int MINIMUM_LENGTH = 12;

    short  flags;
	short  miss_send_len;

    public OFGetConfigReply() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFMessageType.valueOf((byte)8));
    }
    
    public OFGetConfigReply(OFGetConfigReply other) {
    	super(other);
		this.flags = other.flags;
		this.miss_send_len = other.miss_send_len;
    }

	public short getFlags() {
		return this.flags;
	}
	
	public OFGetConfigReply setFlags(short flags) {
		this.flags = flags;
		return this;
	}
			
	public short getMissSendLen() {
		return this.miss_send_len;
	}
	
	public OFGetConfigReply setMissSendLen(short miss_send_len) {
		this.miss_send_len = miss_send_len;
		return this;
	}
			

    public void readFrom(ByteBuffer data) {
        super.readFrom(data);
		this.flags = data.getShort();
		this.miss_send_len = data.getShort();
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        data.putShort(this.flags);
		data.putShort(this.miss_send_len);
    }

    public String toString() {
        return super.toString() +  ":OFGetConfigReply-"+":flags=" + U16.f(flags) + 
		":miss_send_len=" + U16.f(miss_send_len);
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)MINIMUM_LENGTH;
    	
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
        		
		final int prime = 2381;
		int result = super.hashCode() * prime;
		result = prime * result + (int) flags;
		result = prime * result + (int) miss_send_len;
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
        if (!(obj instanceof OFGetConfigReply)) {
            return false;
        }
        OFGetConfigReply other = (OFGetConfigReply) obj;
		if ( flags != other.flags ) return false;
		if ( miss_send_len != other.miss_send_len ) return false;
        return true;
    }
}
