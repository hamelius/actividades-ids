import numpy as np
import matplotlib.pyplot as plt

# Parámetros de muestreo
fs = 1000       # Frecuencia de muestreo (Hz)
T = 1.0         # Duración total (segundos)
t = np.linspace(0, T, int(fs * T), endpoint=False)

# 1. Generación de señales elementales
# A) Señal Senoidal compuesta (50 Hz y 120 Hz)
f1, f2 = 50, 120
x_seno = np.sin(2 * np.pi * f1 * t) + 0.5 * np.sin(2 * np.pi * f2 * t)

# B) Pulso Rectangular (Ventana de duración 0.2s)
ancho_pulso = 0.2
x_rect = np.where((t >= 0.4) & (t <= 0.4 + ancho_pulso), 1.0, 0.0)

# 2. Cálculo de la Transformada de Fourier (FFT)
N = len(t)
X_seno = np.fft.fft(x_seno)
X_rect = np.fft.fft(x_rect)

# Vector de frecuencias correspondiente
frecuencias = np.fft.fftfreq(N, 1/fs)

# Tomar solo la mitad positiva del espectro
n_positivo = N // 2
f_pos = frecuencias[:n_positivo]
mag_seno = np.abs(X_seno[:n_positivo]) / N
mag_rect = np.abs(X_rect[:n_positivo]) / N

# 3. Visualización de Resultados
plt.figure(figsize=(12, 8))

# Gráfica en el dominio del tiempo (Senoidal)
plt.subplot(2, 2, 1)
plt.plot(t[:200], x_seno[:200], color='b')
plt.title('Dominio del Tiempo: Señal Compuesta')
plt.xlabel('Tiempo (s)')
plt.ylabel('Amplitud')
plt.grid(True)

# Espectro de magnitud (Senoidal)
plt.subplot(2, 2, 2)
plt.plot(f_pos, 2 * mag_seno, color='r')
plt.title('Espectro de Magnitud (FFT)')
plt.xlabel('Frecuencia (Hz)')
plt.ylabel('|X(f)|')
plt.xlim(0, 200)
plt.grid(True)

# Gráfica en el dominio del tiempo (Pulso Rectangular)
plt.subplot(2, 2, 3)
plt.plot(t, x_rect, color='g')
plt.title('Dominio del Tiempo: Pulso Rectangular')
plt.xlabel('Tiempo (s)')
plt.ylabel('Amplitud')
plt.grid(True)

# Espectro de magnitud (Pulso Rectangular - Sinc)
plt.subplot(2, 2, 4)
plt.plot(f_pos, 2 * mag_rect, color='m')
plt.title('Espectro de Magnitud (Pulso - Función Sinc)')
plt.xlabel('Frecuencia (Hz)')
plt.ylabel('|X(f)|')
plt.xlim(0, 100)
plt.grid(True)

plt.tight_layout()
plt.show()
