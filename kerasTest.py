from keras.models import Sequential
from keras.layers import Dense,Activation
from keras.optimizers import SGD

model = Sequential()
model.add(Dense(64, input_shape=100))
model.add(Activation("relu"))
