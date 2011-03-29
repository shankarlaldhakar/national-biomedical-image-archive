/**
 * MFTextNode.java
 *
 * This file was generated by MapForce 2011r2sp1.
 *
 * YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
 * OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION.
 *
 * Refer to the MapForce Documentation for further details.
 * http://www.altova.com/mapforce
 */

package com.altova.mapforce;

import javax.xml.namespace.QName;

public class MFTextNode implements IMFNode 
{
	int kind;
	IEnumerable children;
	
	public MFTextNode(boolean cdata, IEnumerable children)
	{
		this.kind = MFNodeKind_Text | (cdata ? MFNodeKind_CData : 0);
		this.children = children;
	}

	public String getLocalName() 
	{
		return "#text";
	}

	public String getNamespaceURI() 
	{
		return "";
	}
	
	public String getPrefix()
	{
		return "";
	}

	public int getNodeKind() 
	{
		return kind;
	}

	public QName getQName() 
	{
		return new QName("", "#text");
	}

	public IEnumerable select(int mfQueryKind, Object query) 
	{
		switch (mfQueryKind)
		{
			case MFQueryKind_All:
			case MFQueryKind_AllChildren:
				return new MFNodeByKindFilter(children, MFNodeKind_Text);
			
			case MFQueryKind_AttributeByQName:
				return new MFEmptySequence();

			case MFQueryKind_ChildrenByQName:
				return new MFEmptySequence();

			case MFQueryKind_SelfByQName:
				return new MFEmptySequence();

			default:
				throw new UnsupportedOperationException("Unsupported query type.");
		}
	}
	
	public String value() throws Exception
	{
		String s =  "";
				
		for (IEnumerator v = select(IMFNode.MFQueryKind_AllChildren, null).enumerator(); v.moveNext();)
		{
			Object o = v.current();
			if (o instanceof IMFNode)
				s += ((IMFNode) o ).value();
			else
				s += o.toString();
		}
		return s;
	}
	
	
	public javax.xml.namespace.QName qnameValue()
	{
		return null;
	}
	
	public Object typedValue() throws Exception
	{
		return MFNode.collectTypedValue(select(IMFNode.MFQueryKind_AllChildren, null));
	}
}
