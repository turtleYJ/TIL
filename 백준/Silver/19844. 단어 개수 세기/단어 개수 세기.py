import re

contractions = ["c'", "j'", "n'", "m'", "t'", "s'", "l'", "d'", "qu'"]

def split_french_words(text):
    words = re.split(r'[ \t\n\r\f\v-]+', text)
    
    expanded_words = []
    
    for word in words:
        matched = False
        for contraction in contractions:
            pattern = re.compile(r"^" + contraction + r"([aeiouh].*)$")
            match = pattern.match(word)
            if match:
                expanded_words.append(contraction)
                expanded_words.append(match.group(1))
                matched = True
                break
        if not matched:
            expanded_words.append(word)

    expanded_words = [word for word in expanded_words if word]

    return expanded_words

def count_french_words(text):
    words = split_french_words(text)
    return len(words)

s = input()
print(count_french_words(s))