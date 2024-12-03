/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.github.manuelarte.kafka.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

/** User events */
@org.apache.avro.specific.AvroGenerated
public class User extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 548363983437165039L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"User\",\"namespace\":\"com.github.manuelarte.kafka.avro\",\"doc\":\"User events\",\"fields\":[{\"name\":\"payload\",\"type\":[{\"type\":\"record\",\"name\":\"UserNew\",\"doc\":\"New User\",\"fields\":[{\"name\":\"id\",\"type\":\"int\",\"doc\":\"The id of the user\"},{\"name\":\"name\",\"type\":\"string\",\"doc\":\"The name of a service instance\"},{\"name\":\"username\",\"type\":\"string\",\"doc\":\"The username of the user\"},{\"name\":\"email\",\"type\":\"string\",\"doc\":\"The email of the user\"}]},{\"type\":\"record\",\"name\":\"UserEmailUpdated\",\"doc\":\"User updated his email\",\"fields\":[{\"name\":\"id\",\"type\":\"int\",\"doc\":\"The id of the user\"},{\"name\":\"email\",\"type\":\"string\",\"doc\":\"The new email of the user\"}]}],\"doc\":\"The different user events\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<User> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<User> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<User> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<User> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<User> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this User to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a User from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a User instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static User fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** The different user events */
  private java.lang.Object payload;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public User() {}

  /**
   * All-args constructor.
   * @param payload The different user events
   */
  public User(java.lang.Object payload) {
    this.payload = payload;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return payload;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: payload = value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'payload' field.
   * @return The different user events
   */
  public java.lang.Object getPayload() {
    return payload;
  }


  /**
   * Sets the value of the 'payload' field.
   * The different user events
   * @param value the value to set.
   */
  public void setPayload(java.lang.Object value) {
    this.payload = value;
  }

  /**
   * Creates a new User RecordBuilder.
   * @return A new User RecordBuilder
   */
  public static com.github.manuelarte.kafka.avro.User.Builder newBuilder() {
    return new com.github.manuelarte.kafka.avro.User.Builder();
  }

  /**
   * Creates a new User RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new User RecordBuilder
   */
  public static com.github.manuelarte.kafka.avro.User.Builder newBuilder(com.github.manuelarte.kafka.avro.User.Builder other) {
    if (other == null) {
      return new com.github.manuelarte.kafka.avro.User.Builder();
    } else {
      return new com.github.manuelarte.kafka.avro.User.Builder(other);
    }
  }

  /**
   * Creates a new User RecordBuilder by copying an existing User instance.
   * @param other The existing instance to copy.
   * @return A new User RecordBuilder
   */
  public static com.github.manuelarte.kafka.avro.User.Builder newBuilder(com.github.manuelarte.kafka.avro.User other) {
    if (other == null) {
      return new com.github.manuelarte.kafka.avro.User.Builder();
    } else {
      return new com.github.manuelarte.kafka.avro.User.Builder(other);
    }
  }

  /**
   * RecordBuilder for User instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<User>
    implements org.apache.avro.data.RecordBuilder<User> {

    /** The different user events */
    private java.lang.Object payload;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.github.manuelarte.kafka.avro.User.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.payload)) {
        this.payload = data().deepCopy(fields()[0].schema(), other.payload);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing User instance
     * @param other The existing instance to copy.
     */
    private Builder(com.github.manuelarte.kafka.avro.User other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.payload)) {
        this.payload = data().deepCopy(fields()[0].schema(), other.payload);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'payload' field.
      * The different user events
      * @return The value.
      */
    public java.lang.Object getPayload() {
      return payload;
    }


    /**
      * Sets the value of the 'payload' field.
      * The different user events
      * @param value The value of 'payload'.
      * @return This builder.
      */
    public com.github.manuelarte.kafka.avro.User.Builder setPayload(java.lang.Object value) {
      validate(fields()[0], value);
      this.payload = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'payload' field has been set.
      * The different user events
      * @return True if the 'payload' field has been set, false otherwise.
      */
    public boolean hasPayload() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'payload' field.
      * The different user events
      * @return This builder.
      */
    public com.github.manuelarte.kafka.avro.User.Builder clearPayload() {
      payload = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public User build() {
      try {
        User record = new User();
        record.payload = fieldSetFlags()[0] ? this.payload :  defaultValue(fields()[0]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<User>
    WRITER$ = (org.apache.avro.io.DatumWriter<User>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<User>
    READER$ = (org.apache.avro.io.DatumReader<User>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










