package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import java.util.List;
import java.util.LinkedList;
import org.openflow.protocol.ver1_3.types.*;

public class OFInstructionApplyActions extends OFInstruction  {
    public static int MINIMUM_LENGTH = 8;

    int pad_1th;
	List<OFAction>  actions;

    public OFInstructionApplyActions() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFInstructionType.valueOf((short)4));
		this.actions = new LinkedList<OFAction>();
    }
    
    public OFInstructionApplyActions(OFInstructionApplyActions other) {
    	super(other);
		this.actions = (other.actions == null)? null: new LinkedList<OFAction>();
		for ( OFAction i : other.actions ) { this.actions.add( new OFAction(i) ); }
    }

	public List<OFAction> getActions() {
		return this.actions;
	}
	
	public OFInstructionApplyActions setActions(List<OFAction> actions) {
		this.actions = actions;
		return this;
	}
			

    public void readFrom(ByteBuffer data) {
        int mark = data.position();
		super.readFrom(data);
		this.pad_1th = data.getInt();
		if (this.actions == null) this.actions = new LinkedList<OFAction>();
		int __cnt = ((int)getLength() - (data.position() - mark));
		while (__cnt > 0) {
		  data.mark();
		  short __t = data.getShort();
		  data.reset();
		  OFAction t = OFActionType.valueOf(__t).newInstance();
		  t.readFrom(data); __cnt -= t.getLength();
		  this.actions.add(t);
		}
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        data.putInt(this.pad_1th);
		if (this.actions != null ) for (OFAction t: this.actions) { t.writeTo(data); }
    }

    public String toString() {
        return super.toString() +  ":OFInstructionApplyActions-"+":actions=" + actions.toString();
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)MINIMUM_LENGTH;
    	for ( OFAction i : this.actions ) { len += i.computeLength(); }
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
        		
		final int prime = 2111;
		int result = super.hashCode() * prime;
		result = prime * result + ((actions == null)?0:actions.hashCode());
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
        if (!(obj instanceof OFInstructionApplyActions)) {
            return false;
        }
        OFInstructionApplyActions other = (OFInstructionApplyActions) obj;
		if ( actions == null && other.actions != null ) { return false; }
		else if ( !actions.equals(other.actions) ) { return false; }
        return true;
    }
}
