package org.openflow.protocol.ver1_0.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_0.types.*;

public class OFActionSetVlanPcp extends OFAction  {
    public static int MINIMUM_LENGTH = 8;

    byte  vlan_pcp;
	short pad_1th;
	byte pad_2th;

    public OFActionSetVlanPcp() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFActionType.valueOf((short)2));
    }
    
    public OFActionSetVlanPcp(OFActionSetVlanPcp other) {
    	super(other);
		this.vlan_pcp = other.vlan_pcp;
    }

	public byte getVlanPcp() {
		return this.vlan_pcp;
	}
	
	public OFActionSetVlanPcp setVlanPcp(byte vlan_pcp) {
		this.vlan_pcp = vlan_pcp;
		return this;
	}
			

    public void readFrom(ByteBuffer data) {
        super.readFrom(data);
		this.vlan_pcp = data.get();
		this.pad_1th = data.getShort();
		this.pad_2th = data.get();
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        data.put(this.vlan_pcp);
		data.putShort(this.pad_1th);
		data.put(this.pad_2th);
    }

    public String toString() {
        return super.toString() +  ":OFActionSetVlanPcp-"+":vlan_pcp=" + U8.f(vlan_pcp);
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
        		
		final int prime = 2819;
		int result = super.hashCode() * prime;
		result = prime * result + (int) vlan_pcp;
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
        if (!(obj instanceof OFActionSetVlanPcp)) {
            return false;
        }
        OFActionSetVlanPcp other = (OFActionSetVlanPcp) obj;
		if ( vlan_pcp != other.vlan_pcp ) return false;
        return true;
    }
}
