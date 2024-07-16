class TestCase:
    def __init__(self, name):
        print("TestCase init")
        self.name = name
    def setUp(self):
        print("TestCase setUp")
        pass
    def run(self):
        print("TestCase run")
        self.setUp()
        method = getattr(self, self.name)
        method()

class WasRun(TestCase):
    def __init__(self, name):
        print("WasRun init")
        TestCase.__init__(self, name)
    def testMethod(self):
        print("WasRun testMethod")
        self.wasRun = 1
    def setUp(self):
        print("WasRun setUp")
        self.wasRun = None
        self.wasSetUp = 1
        
class TestCaseTest(TestCase):
    def setUp(self):
        print("TestCaseTest setUp")
        self.test = WasRun("testMethod")
    def testRunning(self):
        print("TestCaseTest testRunning")
        self.test.run()
        assert(self.test.wasRun)
    def testSetUp(self):
        print("TestCaseTest testSetUp")
        self.test.run()
        assert(self.test.wasSetUp)
        
TestCaseTest("testRunning").run()
TestCaseTest("testSetUp").run()