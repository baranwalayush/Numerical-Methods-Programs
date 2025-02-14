import numpy as np
import matplotlib.pyplot as plt

def func(x):
    return x**4

def error(exact, present):
    error = abs(exact-present)/abs(exact)
    return error*100

def differentiation(x):
    return 4*(x**3)

def fds(x, step):
    fds_val = (func(x+step) - func(x))/(step)
    return fds_val

def bds(x, step):
    bds_val = (func(x) - func(x-step))/(step)
    return bds_val

def cds(x, step):
    cds_val = (func(x+step) - func(x-step))/(2*step)
    return cds_val

step=0.5
x=0.5
x_fds=[]
x_bds=[]
x_cds=[]
y=[]
exact_value = differentiation(x)

# Exact value visualization

for i in range(0,10):
    y.append((step))
    fds_val = fds(x, step)
    bds_val = bds(x, step)
    cds_val = cds(x, step)

    fds_error = np.log10(error(exact_value, fds_val))
    bds_error = np.log10(error(exact_value, bds_val))
    cds_error = np.log10(error(exact_value, cds_val))

    x_fds.append(fds_error)
    x_bds.append(bds_error)
    x_cds.append(cds_error)

    print(fds_error, bds_error, cds_error, step)

    step= step-0.05

# Log scale results for better visualization

# for i in range(0,8):
#     y.append(np.log10(step))
#     fds_val = fds(x, step)
#     bds_val = bds(x, step)
#     cds_val = cds(x, step)

#     fds_error = np.log10(error(exact_value, fds_val))
#     bds_error = np.log10(error(exact_value, bds_val))
#     cds_error = np.log10(error(exact_value, cds_val))

#     x_fds.append(fds_error)
#     x_bds.append(bds_error)
#     x_cds.append(cds_error)

#     step= step-0.01

#     print(fds_error, bds_error, cds_error, x, step)


plt.plot(y, x_fds, label="fds", color="red")
plt.plot(y, x_bds, label="bds", color="blue")
plt.plot(y, x_cds, label="cds", color="green")
plt.legend()
plt.grid()

plt.show()




