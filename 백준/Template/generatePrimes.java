    private static List generatePrimes(int toGenerate) {
		List<Integer> primes = new ArrayList<>();
		primes.add(2);
		primes.add(3);
		
		while (primes.size() < toGenerate) {
			int nextPrime = (primes.get(primes.size() - 1)) + 2;
			
			while (true) {
				boolean isPrime = true;
				for (Integer num : primes) {
					if (nextPrime % num == 0) {
						isPrime = false;
						break;
					}
				}
				
				if (isPrime) {
					break;
				} else {
					nextPrime += 2;
				}
			}
			
			primes.add(nextPrime);
		}
		return primes;
	}