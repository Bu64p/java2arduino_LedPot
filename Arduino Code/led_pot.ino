int ledPin = 5; // pin must be PWM
int serialBaudRate = 9600; // must be same as Java program BaudRate
void setup() {
  Serial.begin(serialBaudRate);
  pinMode(ledPin,OUTPUT);
}
void loop() {
  int input = Serial.parseInt();
  // input's range is from 0 to 100 but PWM's range is from 0 to 255, so we should convert input:
  int output =  input*255./100.;
  analogWrite(ledPin,output);
}
