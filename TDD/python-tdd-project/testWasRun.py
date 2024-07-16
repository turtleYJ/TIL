class TestCase:
    def __init__(self, name):
        self.name = name
    def setUp(self):
        pass
    def run(self):
        self.setUp()
        method = getattr(self, self.name)
        method()

class WasRun(TestCase):
    def __init__(self, name):
        TestCase.__init__(self, name)
    def testMethod(self):
        self.log = self.log + "testMethod "
    def setUp(self):
        self.log = "setUp "
        
class TestCaseTest(TestCase):
    def setUp(self):
        self.test = WasRun("testMethod")
    def testTemplateMethod(self):
        self.test.run()
        assert(self.test.log == "setUp testMethod ")
        
TestCaseTest("testTemplateMethod").run()